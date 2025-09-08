package com.example.reservasalocacao.service.impl;

import com.example.reservasalocacao.dto.ambiente.AmbienteDTO;
import com.example.reservasalocacao.dto.ambiente.AmbienteCreateDTO;
import com.example.reservasalocacao.entity.Ambiente;
import com.example.reservasalocacao.exception.ResourceNotFoundException;
import com.example.reservasalocacao.repository.AmbienteRepository;
import com.example.reservasalocacao.service.AmbienteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AmbienteServiceImpl implements AmbienteService {

    private final AmbienteRepository repository;
    private final ModelMapper modelMapper;

    public AmbienteServiceImpl(AmbienteRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    private AmbienteDTO toDto(Ambiente e) {
        return modelMapper.map(e, AmbienteDTO.class);
    }

    private Ambiente toEntity(AmbienteCreateDTO dto) {
        return modelMapper.map(dto, Ambiente.class);
    }

    @Override
    public List<AmbienteDTO> findAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public AmbienteDTO findById(Long id) {
        Ambiente e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ambiente not found: " + id));
        return toDto(e);
    }

    @Override
    public AmbienteDTO create(AmbienteCreateDTO dto) {
        Ambiente entity = toEntity(dto);
        Ambiente saved = repository.save(entity);
        return toDto(saved);
    }

    @Override
    public AmbienteDTO update(Long id, AmbienteCreateDTO dto) {
        Ambiente entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ambiente not found: " + id));
        modelMapper.map(dto, entity);
        Ambiente updated = repository.save(entity);
        return toDto(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Ambiente not found: " + id);
        }
        repository.deleteById(id);
    }
}