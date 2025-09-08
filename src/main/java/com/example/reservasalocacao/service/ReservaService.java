package com.example.reservasalocacao.service;

import com.example.reservasalocacao.dto.reserva.ReservaDTO;
import com.example.reservasalocacao.dto.reserva.ReservaCreateDTO;
import java.util.List;

public interface ReservaService {
    List<ReservaDTO> findAll();
    ReservaDTO findById(Long id);
    ReservaDTO create(ReservaCreateDTO dto);
    ReservaDTO update(Long id, ReservaCreateDTO dto);
    void delete(Long id);
}
