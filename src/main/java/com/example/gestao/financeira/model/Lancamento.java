package com.example.gestao.financeira.model;

import com.example.gestao.financeira.Enum.Categoria;
import com.example.gestao.financeira.Enum.Tipo;
import com.example.gestao.financeira.Enum.Moeda;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "lancamento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    private BigDecimal valor;

    private BigDecimal valorConvertido;

    private BigDecimal taxaDeConversao;

    @Enumerated(EnumType.STRING)
    private Moeda moeda;

    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;


}
