package com.example.reservasalocacao.repository;

import com.example.reservasalocacao.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {}
