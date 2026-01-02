package com.example.gestao.financeira.service;

import com.example.gestao.financeira.DTO.LacamentoDto;
import com.example.gestao.financeira.Exceptions.RegraNegocioException;
import com.example.gestao.financeira.Repository.LacamentoRepository;
import com.example.gestao.financeira.model.Lancamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LacamentoService {

    @Autowired
    private LacamentoRepository repository;

    public void criarLancamento(LacamentoDto dto) {
        if (dto.valor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RegraNegocioException("o deve ser maior que zero");
        }
        Lancamento lanca = new Lancamento();
        lanca.setDescricao(dto.descricao());
        lanca.setValor(dto.valor());
        lanca.setMoeda(dto.moeda());
        lanca.setData(dto.data());
        lanca.setCategoria(dto.categoria());
        lanca.setTipo(dto.tipo());
        repository.save(lanca);


    }
}
