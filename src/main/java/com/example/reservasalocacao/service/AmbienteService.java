package com.example.reservasalocacao.service;

import com.example.reservasalocacao.dto.ambiente.AmbienteDTO;
import com.example.reservasalocacao.dto.ambiente.AmbienteCreateDTO;
import java.util.List;

public interface AmbienteService {
    List<AmbienteDTO> findAll();
    AmbienteDTO findById(Long id);
    AmbienteDTO create(AmbienteCreateDTO dto);
    AmbienteDTO update(Long id, AmbienteCreateDTO dto);
    void delete(Long id);
}
