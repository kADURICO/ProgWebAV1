package com.example.reservasalocacao.repository;

import com.example.reservasalocacao.entity.RegistroUtilizacaoAmbiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroUtilizacaoAmbienteRepository extends JpaRepository<RegistroUtilizacaoAmbiente, Long> {}
