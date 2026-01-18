package com.example.gestao.financeira.DTO;

import com.example.gestao.financeira.Enum.Categoria;

import java.math.BigDecimal;
import java.util.Map;

public record RelatorioResumoDto(
      BigDecimal totalEntradas,
        BigDecimal   totalSaida,
        BigDecimal saldo,
        Map<Categoria,BigDecimal> gastoPorCategoria
) {
}
