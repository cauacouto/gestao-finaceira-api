package com.example.gestao.financeira.model;

import com.example.gestao.financeira.Enum.Categoria;
import com.example.gestao.financeira.Enum.Tipo;
import com.example.gestao.financeira.Enum.Moeda;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "lancamento")
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(nullable = false,updatable = false)
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @PrePersist
    public void PrePersist(){
      this.data = LocalDate.now();
    }

    public Lancamento(String descricao, BigDecimal valor, Moeda moeda, Tipo tipo, Categoria categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.moeda = moeda;
        this.tipo = tipo;
        this.categoria = categoria;

    }
}
