package com.example.reservasalocacao.repository;

import com.example.reservasalocacao.entity.DiasSemAlocacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiasSemAlocacaoRepository extends JpaRepository<DiasSemAlocacao, Long> {}
