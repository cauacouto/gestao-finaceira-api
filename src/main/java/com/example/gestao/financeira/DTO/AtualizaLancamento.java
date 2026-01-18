package com.example.gestao.financeira.DTO;

import com.example.gestao.financeira.Enum.Categoria;
import com.example.gestao.financeira.Enum.Moeda;
import com.example.gestao.financeira.Enum.Tipo;

import java.math.BigDecimal;

public record AtualizaLancamento(

        String descricao,
        BigDecimal valor,
        Moeda moeda,
        Categoria categoria,
        Tipo tipo
)
        {
}
