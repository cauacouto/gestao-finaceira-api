package com.example.gestao.financeira.Repository;

import com.example.gestao.financeira.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LacamentoRepository extends JpaRepository<Lancamento,Integer> {

    @Query("SELECT l FROM Lancamento l WHERE MONTH(l.data) = :mes AND YEAR(l.data) = :ano")
    List<Lancamento> findByMesEAno(@Param("mes") int mes, @Param("ano") int ano);
}
