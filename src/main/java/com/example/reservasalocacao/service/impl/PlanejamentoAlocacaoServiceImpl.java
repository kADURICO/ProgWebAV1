package com.example.reservasalocacao.service.impl;

import com.example.reservasalocacao.dto.planejamentoalocacao.PlanejamentoAlocacaoDTO;
import com.example.reservasalocacao.dto.planejamentoalocacao.PlanejamentoAlocacaoCreateDTO;
import com.example.reservasalocacao.entity.Ambiente;
import com.example.reservasalocacao.entity.PlanejamentoAlocacao;
import com.example.reservasalocacao.entity.ReservaAlocacao;
import com.example.reservasalocacao.entity.Usuario;
import com.example.reservasalocacao.exception.ResourceNotFoundException;
import com.example.reservasalocacao.repository.AmbienteRepository;
import com.example.reservasalocacao.repository.PlanejamentoAlocacaoRepository;
import com.example.reservasalocacao.repository.ReservaAlocacaoRepository;
import com.example.reservasalocacao.repository.UsuarioRepository;
import com.example.reservasalocacao.service.PlanejamentoAlocacaoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlanejamentoAlocacaoServiceImpl implements PlanejamentoAlocacaoService {

    private final PlanejamentoAlocacaoRepository repository;
    private final AmbienteRepository ambienteRepository;
    private final UsuarioRepository usuarioRepository;
    private final ReservaAlocacaoRepository reservaAlocacaoRepository;
    private final ModelMapper modelMapper;

    public PlanejamentoAlocacaoServiceImpl(
            PlanejamentoAlocacaoRepository repository,
            AmbienteRepository ambienteRepository,
            UsuarioRepository usuarioRepository,
            ReservaAlocacaoRepository reservaAlocacaoRepository,
            ModelMapper modelMapper) {
        this.repository = repository;
        this.ambienteRepository = ambienteRepository;
        this.usuarioRepository = usuarioRepository;
        this.reservaAlocacaoRepository = reservaAlocacaoRepository;
        this.modelMapper = modelMapper;
    }

    private PlanejamentoAlocacaoDTO toDto(PlanejamentoAlocacao e) {
        return modelMapper.map(e, PlanejamentoAlocacaoDTO.class);
    }

    private PlanejamentoAlocacao toEntity(PlanejamentoAlocacaoCreateDTO dto) {
        return modelMapper.map(dto, PlanejamentoAlocacao.class);
    }

    @Override
    public List<PlanejamentoAlocacaoDTO> findAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public PlanejamentoAlocacaoDTO findById(Long id) {
        PlanejamentoAlocacao e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PlanejamentoAlocacao not found: " + id));
        return toDto(e);
    }

    @Override
    public PlanejamentoAlocacaoDTO create(PlanejamentoAlocacaoCreateDTO dto) {
        PlanejamentoAlocacao entity = toEntity(dto);

        // Busca e associa as entidades relacionadas
        entity.setAmbiente(ambienteRepository.findById(dto.getAmbienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Ambiente not found: " + dto.getAmbienteId())));

        entity.setUsuario(usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario not found: " + dto.getUsuarioId())));

        if (dto.getReservaAlocacaoId() != null) {
            entity.setReservaAlocacao(reservaAlocacaoRepository.findById(dto.getReservaAlocacaoId())
                    .orElseThrow(() -> new ResourceNotFoundException("ReservaAlocacao not found: " + dto.getReservaAlocacaoId())));
        }

        PlanejamentoAlocacao saved = repository.save(entity);
        return toDto(saved);
    }

    @Override
    public PlanejamentoAlocacaoDTO update(Long id, PlanejamentoAlocacaoCreateDTO dto) {
        PlanejamentoAlocacao entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PlanejamentoAlocacao not found: " + id));

        // Mapeia os campos do DTO para a entidade existente
        modelMapper.map(dto, entity);

        // Atualiza as entidades relacionadas se os IDs foram fornecidos no DTO
        if (dto.getAmbienteId() != null) {
            entity.setAmbiente(ambienteRepository.findById(dto.getAmbienteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Ambiente not found: " + dto.getAmbienteId())));
        }

        if (dto.getUsuarioId() != null) {
            entity.setUsuario(usuarioRepository.findById(dto.getUsuarioId())
                    .orElseThrow(() -> new ResourceNotFoundException("Usuario not found: " + dto.getUsuarioId())));
        }

        if (dto.getReservaAlocacaoId() != null) {
            entity.setReservaAlocacao(reservaAlocacaoRepository.findById(dto.getReservaAlocacaoId())
                    .orElseThrow(() -> new ResourceNotFoundException("ReservaAlocacao not found: " + dto.getReservaAlocacaoId())));
        }

        PlanejamentoAlocacao updated = repository.save(entity);
        return toDto(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("PlanejamentoAlocacao not found: " + id);
        }
        repository.deleteById(id);
    }
}