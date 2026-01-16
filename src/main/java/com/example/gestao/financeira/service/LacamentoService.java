package com.example.gestao.financeira.service;

import com.example.gestao.financeira.DTO.LacamentoDto;
import com.example.gestao.financeira.DTO.LacamentoResponseDto;
import com.example.gestao.financeira.Enum.Categoria;
import com.example.gestao.financeira.Enum.Moeda;
import com.example.gestao.financeira.Enum.Tipo;
import com.example.gestao.financeira.Exceptions.RegraNegocioException;
import com.example.gestao.financeira.Repository.LacamentoRepository;
import com.example.gestao.financeira.model.Lancamento;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LacamentoService {

    private final LacamentoRepository lacamentoRepository;

    public LacamentoService(LacamentoRepository lacamentoRepository) {
        this.lacamentoRepository = lacamentoRepository;
    }

    @Transactional
    public LacamentoResponseDto criarLancamento(LacamentoDto dto) {
        if (dto.valor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RegraNegocioException("o valor deve ser maior que zero");
        }
        Lancamento lanca = new Lancamento(
                dto.descricao(),
                dto.valor(),
                dto.moeda(),
                dto.tipo(),
                dto.categoria()

        );
       lacamentoRepository.save(lanca);
      return new LacamentoResponseDto(
           lanca.getDescricao(),
              lanca.getValor(),
              lanca.getMoeda(),
              lanca.getCategoria(),
              lanca.getTipo(),
              lanca.getData()
      );
    }
}
