package com.example.reservasalocacao.repository;

import com.example.reservasalocacao.entity.PlanejamentoAlocacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanejamentoAlocacaoRepository extends JpaRepository<PlanejamentoAlocacao, Long> {}
