package com.example.reservasalocacao.service;

import com.example.reservasalocacao.dto.planejamentoalocacao.PlanejamentoAlocacaoDTO;
import com.example.reservasalocacao.dto.planejamentoalocacao.PlanejamentoAlocacaoCreateDTO;
import java.util.List;

public interface PlanejamentoAlocacaoService {
    List<PlanejamentoAlocacaoDTO> findAll();
    PlanejamentoAlocacaoDTO findById(Long id);
    PlanejamentoAlocacaoDTO create(PlanejamentoAlocacaoCreateDTO dto);
    PlanejamentoAlocacaoDTO update(Long id, PlanejamentoAlocacaoCreateDTO dto);
    void delete(Long id);
}
