package com.example.gestao.financeira.service;

import com.example.gestao.financeira.DTO.AtualizaLancamento;
import com.example.gestao.financeira.DTO.LacamentoRequestDto;
import com.example.gestao.financeira.DTO.LacamentoResponseDto;
import com.example.gestao.financeira.DTO.RelatorioResumoDto;
import com.example.gestao.financeira.Enum.Categoria;
import com.example.gestao.financeira.Enum.Tipo;
import com.example.gestao.financeira.Exceptions.RegraNegocioException;
import com.example.gestao.financeira.mapper.LancamentoMapper;
import com.example.gestao.financeira.Repository.LacamentoRepository;
import com.example.gestao.financeira.model.Lancamento;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LacamentoService {

    private final LacamentoRepository lacamentoRepository;
    private final LancamentoMapper lancamentoMapper;

    public LacamentoService(LacamentoRepository lacamentoRepository, LancamentoMapper lancamentoMapper) {
        this.lacamentoRepository = lacamentoRepository;
        this.lancamentoMapper = lancamentoMapper;
    }

    @Transactional
    public LacamentoResponseDto criarLancamento(LacamentoRequestDto dto) {
        if (dto.valor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RegraNegocioException("o valor deve ser maior que zero");
        }
       Lancamento lancamento = lancamentoMapper.toEntity(dto);
        lacamentoRepository.save(lancamento);
        return lancamentoMapper.toResponseDto(lancamento);

    }
    @Transactional()
    public RelatorioResumoDto gerarRelatorio(int mes, int ano){
        List<Lancamento> lancamento = lacamentoRepository.findByMesEAno(mes, ano);

        BigDecimal totalEntradas = lancamento.stream()
                .filter(l -> l.getTipo() == Tipo.RECEITA)
                .map(Lancamento::getValor)
                .reduce(BigDecimal.ZERO,BigDecimal::add);

        BigDecimal totalSaida = lancamento.stream()
                .filter(l-> l.getTipo() == Tipo.DESPESA)
                .map(Lancamento::getValor)
                .reduce(BigDecimal.ZERO,BigDecimal::add);


        Map<Categoria, BigDecimal> gastosPorCategoria = lancamento.stream()
                .filter( l-> l.getTipo() == Tipo.DESPESA)
                .collect(Collectors.groupingBy(
                       Lancamento::getCategoria,
                        Collectors.reducing(BigDecimal.ZERO,Lancamento::getValor,BigDecimal::add)
                ));



        return new RelatorioResumoDto(
                totalEntradas,
                totalSaida,
                totalEntradas.subtract(totalSaida),
                gastosPorCategoria

        );
    }

    public LacamentoResponseDto atualizarLancamento(Integer id , AtualizaLancamento dto){
        Lancamento lancamentoExiste = lacamentoRepository.findById(id)
                .orElseThrow(()-> new RegraNegocioException("lançamento nao encotrado" + id));
         lancamentoMapper.updateLancamentoFromDto(dto,lancamentoExiste);
      Lancamento lancamentoSalvo =    lacamentoRepository.save(lancamentoExiste);
         return lancamentoMapper.toResponseDto(lancamentoSalvo);

    }

    public void excluirLancamento(Integer id){
        if (!lacamentoRepository.existsById(id)){
            throw new RegraNegocioException("lançamento não encontrado");
        }
        lacamentoRepository.deleteById(id);
    }
}

