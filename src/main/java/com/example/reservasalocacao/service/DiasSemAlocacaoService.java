package com.example.reservasalocacao.service;

import com.example.reservasalocacao.dto.diassemalocacao.DiasSemAlocacaoDTO;
import com.example.reservasalocacao.dto.diassemalocacao.DiasSemAlocacaoCreateDTO;
import java.util.List;

public interface DiasSemAlocacaoService {
    List<DiasSemAlocacaoDTO> findAll();
    DiasSemAlocacaoDTO findById(Long id);
    DiasSemAlocacaoDTO create(DiasSemAlocacaoCreateDTO dto);
    DiasSemAlocacaoDTO update(Long id, DiasSemAlocacaoCreateDTO dto);
    void delete(Long id);
}
