package com.example.reservasalocacao.service.impl;

import com.example.reservasalocacao.dto.reserva.ReservaDTO;
import com.example.reservasalocacao.dto.reserva.ReservaCreateDTO;
import com.example.reservasalocacao.entity.Reserva;
import com.example.reservasalocacao.entity.Sala;
import com.example.reservasalocacao.exception.ResourceNotFoundException;
import com.example.reservasalocacao.repository.ReservaRepository;
import com.example.reservasalocacao.repository.SalaRepository;
import com.example.reservasalocacao.service.ReservaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository repository;
    private final SalaRepository salaRepository;
    private final ModelMapper modelMapper;

    public ReservaServiceImpl(ReservaRepository repository, SalaRepository salaRepository, ModelMapper modelMapper) {
        this.repository = repository;
        this.salaRepository = salaRepository;
        this.modelMapper = modelMapper;
    }

    private ReservaDTO toDto(Reserva e) {
        return modelMapper.map(e, ReservaDTO.class);
    }

    private Reserva toEntity(ReservaCreateDTO dto) {
        return modelMapper.map(dto, Reserva.class);
    }

    @Override
    public List<ReservaDTO> findAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ReservaDTO findById(Long id) {
        Reserva e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reserva not found: " + id));
        return toDto(e);
    }

    @Override
    public ReservaDTO create(ReservaCreateDTO dto) {
        Reserva entity = toEntity(dto);

        Sala sala = salaRepository.findById(dto.getSalaId())
                .orElseThrow(() -> new ResourceNotFoundException("Sala not found: " + dto.getSalaId()));

        entity.setSala(sala);

        Reserva saved = repository.save(entity);
        return toDto(saved);
    }

    @Override
    public ReservaDTO update(Long id, ReservaCreateDTO dto) {
        Reserva entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reserva not found: " + id));

        modelMapper.map(dto, entity);

        if (dto.getSalaId() != null) {
            Sala sala = salaRepository.findById(dto.getSalaId())
                    .orElseThrow(() -> new ResourceNotFoundException("Sala not found: " + dto.getSalaId()));
            entity.setSala(sala);
        }

        Reserva updated = repository.save(entity);
        return toDto(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Reserva not found: " + id);
        }
        repository.deleteById(id);
    }
}