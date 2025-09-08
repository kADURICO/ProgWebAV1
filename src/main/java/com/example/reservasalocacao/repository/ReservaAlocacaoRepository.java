package com.example.reservasalocacao.repository;

import com.example.reservasalocacao.entity.ReservaAlocacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaAlocacaoRepository extends JpaRepository<ReservaAlocacao, Long> {}
