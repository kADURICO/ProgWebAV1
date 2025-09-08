package com.example.reservasalocacao.service;

import com.example.reservasalocacao.dto.sala.SalaDTO;
import com.example.reservasalocacao.dto.sala.SalaCreateDTO;
import java.util.List;

public interface SalaService {
    List<SalaDTO> findAll();
    SalaDTO findById(Long id);
    SalaDTO create(SalaCreateDTO dto);
    SalaDTO update(Long id, SalaCreateDTO dto);
    void delete(Long id);
}
