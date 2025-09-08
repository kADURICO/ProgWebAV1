package com.example.reservasalocacao.service;

import com.example.reservasalocacao.dto.reservaalocacao.ReservaAlocacaoDTO;
import com.example.reservasalocacao.dto.reservaalocacao.ReservaAlocacaoCreateDTO;
import java.util.List;

public interface ReservaAlocacaoService {
    List<ReservaAlocacaoDTO> findAll();
    ReservaAlocacaoDTO findById(Long id);
    ReservaAlocacaoDTO create(ReservaAlocacaoCreateDTO dto);
    ReservaAlocacaoDTO update(Long id, ReservaAlocacaoCreateDTO dto);
    void delete(Long id);
}
