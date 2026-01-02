package com.example.gestao.financeira.Repository;

import com.example.gestao.financeira.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LacamentoRepository extends JpaRepository<Lancamento,Integer> {
}
