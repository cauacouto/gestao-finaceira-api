package com.example.gestao.financeira.DTO;

import com.example.gestao.financeira.Enum.Categoria;
import com.example.gestao.financeira.Enum.Moeda;
import com.example.gestao.financeira.Enum.Tipo;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LacamentoDto(String descricao, BigDecimal valor, Moeda moeda, LocalDate data, Categoria categoria,
                           Tipo tipo) {
}
