package com.example.gestao.financeira.DTO;

import com.example.gestao.financeira.Enum.Categoria;
import com.example.gestao.financeira.Enum.Moeda;
import com.example.gestao.financeira.Enum.Tipo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LacamentoResponseDto(

        String descricao,
        BigDecimal valor,
        Moeda moeda,
        Categoria categoria,
        Tipo tipo,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate data) {
}
