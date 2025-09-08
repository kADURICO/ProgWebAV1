package com.example.reservasalocacao.repository;

import com.example.reservasalocacao.entity.Ambiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbienteRepository extends JpaRepository<Ambiente, Long> {}
