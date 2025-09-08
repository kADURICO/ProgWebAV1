package com.example.reservasalocacao.service.impl;

import com.example.reservasalocacao.dto.diassemalocacao.DiasSemAlocacaoDTO;
import com.example.reservasalocacao.dto.diassemalocacao.DiasSemAlocacaoCreateDTO;
import com.example.reservasalocacao.entity.Ambiente;
import com.example.reservasalocacao.entity.DiasSemAlocacao;
import com.example.reservasalocacao.exception.ResourceNotFoundException;
import com.example.reservasalocacao.repository.AmbienteRepository;
import com.example.reservasalocacao.repository.DiasSemAlocacaoRepository;
import com.example.reservasalocacao.service.DiasSemAlocacaoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DiasSemAlocacaoServiceImpl implements DiasSemAlocacaoService {

    private final DiasSemAlocacaoRepository repository;
    private final AmbienteRepository ambienteRepository;
    private final ModelMapper modelMapper;

    public DiasSemAlocacaoServiceImpl(DiasSemAlocacaoRepository repository, AmbienteRepository ambienteRepository, ModelMapper modelMapper) {
        this.repository = repository;
        this.ambienteRepository = ambienteRepository;
        this.modelMapper = modelMapper;
    }

    private DiasSemAlocacaoDTO toDto(DiasSemAlocacao e) {
        return modelMapper.map(e, DiasSemAlocacaoDTO.class);
    }

    private DiasSemAlocacao toEntity(DiasSemAlocacaoCreateDTO dto) {
        return modelMapper.map(dto, DiasSemAlocacao.class);
    }

    @Override
    public List<DiasSemAlocacaoDTO> findAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public DiasSemAlocacaoDTO findById(Long id) {
        DiasSemAlocacao e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("DiasSemAlocacao not found: " + id));
        return toDto(e);
    }

    @Override
    public DiasSemAlocacaoDTO create(DiasSemAlocacaoCreateDTO dto) {
        DiasSemAlocacao entity = toEntity(dto);

        Ambiente ambiente = ambienteRepository.findById(dto.getAmbienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Ambiente not found: " + dto.getAmbienteId()));

        entity.setAmbiente(ambiente);

        DiasSemAlocacao saved = repository.save(entity);
        return toDto(saved);
    }

    @Override
    public DiasSemAlocacaoDTO update(Long id, DiasSemAlocacaoCreateDTO dto) {
        DiasSemAlocacao entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("DiasSemAlocacao not found: " + id));

        modelMapper.map(dto, entity);

        if (dto.getAmbienteId() != null) {
            Ambiente ambiente = ambienteRepository.findById(dto.getAmbienteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Ambiente not found: " + dto.getAmbienteId()));
            entity.setAmbiente(ambiente);
        }

        DiasSemAlocacao updated = repository.save(entity);
        return toDto(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("DiasSemAlocacao not found: " + id);
        }
        repository.deleteById(id);
    }
}