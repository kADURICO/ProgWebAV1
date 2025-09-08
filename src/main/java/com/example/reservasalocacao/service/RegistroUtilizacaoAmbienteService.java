package com.example.reservasalocacao.service;

import com.example.reservasalocacao.dto.registroutilizacaoambiente.RegistroUtilizacaoAmbienteDTO;
import com.example.reservasalocacao.dto.registroutilizacaoambiente.RegistroUtilizacaoAmbienteCreateDTO;
import java.util.List;

public interface RegistroUtilizacaoAmbienteService {
    List<RegistroUtilizacaoAmbienteDTO> findAll();
    RegistroUtilizacaoAmbienteDTO findById(Long id);
    RegistroUtilizacaoAmbienteDTO create(RegistroUtilizacaoAmbienteCreateDTO dto);
    RegistroUtilizacaoAmbienteDTO update(Long id, RegistroUtilizacaoAmbienteCreateDTO dto);
    void delete(Long id);
}
