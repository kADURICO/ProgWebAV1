package com.example.reservasalocacao.service.impl;

import com.example.reservasalocacao.dto.sala.SalaDTO;
import com.example.reservasalocacao.dto.sala.SalaCreateDTO;
import com.example.reservasalocacao.entity.Sala;
import com.example.reservasalocacao.exception.ResourceNotFoundException;
import com.example.reservasalocacao.repository.SalaRepository;
import com.example.reservasalocacao.service.SalaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SalaServiceImpl implements SalaService {

    private final SalaRepository repository;
    private final ModelMapper modelMapper;

    public SalaServiceImpl(SalaRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    private SalaDTO toDto(Sala e) {
        return modelMapper.map(e, SalaDTO.class);
    }

    private Sala toEntity(SalaCreateDTO dto) {
        return modelMapper.map(dto, Sala.class);
    }

    @Override
    public List<SalaDTO> findAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public SalaDTO findById(Long id) {
        Sala e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sala not found: " + id));
        return toDto(e);
    }

    @Override
    public SalaDTO create(SalaCreateDTO dto) {
        Sala entity = toEntity(dto);
        Sala saved = repository.save(entity);
        return toDto(saved);
    }

    @Override
    public SalaDTO update(Long id, SalaCreateDTO dto) {
        Sala entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sala not found: " + id));
        modelMapper.map(dto, entity);
        Sala updated = repository.save(entity);
        return toDto(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Sala not found: " + id);
        }
        repository.deleteById(id);
    }
}