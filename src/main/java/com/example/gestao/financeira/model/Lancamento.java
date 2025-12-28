package com.example.gestao.financeira.model;

import com.example.gestao.financeira.Enum.Categoria;
import com.example.gestao.financeira.Enum.Tipo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "lançamento")
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
    private Double valor;
    private LocalDate data;
    @Enumerated(EnumType.STRING)
     private Categoria categoria;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

}
