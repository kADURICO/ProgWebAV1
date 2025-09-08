package com.example.reservasalocacao.service.impl;

import com.example.reservasalocacao.dto.registroutilizacaoambiente.RegistroUtilizacaoAmbienteDTO;
import com.example.reservasalocacao.dto.registroutilizacaoambiente.RegistroUtilizacaoAmbienteCreateDTO;
import com.example.reservasalocacao.entity.RegistroUtilizacaoAmbiente;
import com.example.reservasalocacao.entity.Usuario;
import com.example.reservasalocacao.entity.Ambiente;
import com.example.reservasalocacao.entity.PlanejamentoAlocacao;
import com.example.reservasalocacao.exception.ResourceNotFoundException;
import com.example.reservasalocacao.repository.RegistroUtilizacaoAmbienteRepository;
import com.example.reservasalocacao.repository.UsuarioRepository;
import com.example.reservasalocacao.repository.AmbienteRepository;
import com.example.reservasalocacao.repository.PlanejamentoAlocacaoRepository;
import com.example.reservasalocacao.service.RegistroUtilizacaoAmbienteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RegistroUtilizacaoAmbienteServiceImpl implements RegistroUtilizacaoAmbienteService {

    private final RegistroUtilizacaoAmbienteRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final AmbienteRepository ambienteRepository;
    private final PlanejamentoAlocacaoRepository planejamentoAlocacaoRepository;
    private final ModelMapper modelMapper;

    public RegistroUtilizacaoAmbienteServiceImpl(
            RegistroUtilizacaoAmbienteRepository repository,
            UsuarioRepository usuarioRepository,
            AmbienteRepository ambienteRepository,
            PlanejamentoAlocacaoRepository planejamentoAlocacaoRepository,
            ModelMapper modelMapper) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        this.ambienteRepository = ambienteRepository;
        this.planejamentoAlocacaoRepository = planejamentoAlocacaoRepository;
        this.modelMapper = modelMapper;
    }

    private RegistroUtilizacaoAmbienteDTO toDto(RegistroUtilizacaoAmbiente e) {
        return modelMapper.map(e, RegistroUtilizacaoAmbienteDTO.class);
    }

    private RegistroUtilizacaoAmbiente toEntity(RegistroUtilizacaoAmbienteCreateDTO dto) {
        return modelMapper.map(dto, RegistroUtilizacaoAmbiente.class);
    }

    @Override
    public List<RegistroUtilizacaoAmbienteDTO> findAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public RegistroUtilizacaoAmbienteDTO findById(Long id) {
        RegistroUtilizacaoAmbiente e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RegistroUtilizacaoAmbiente not found: " + id));
        return toDto(e);
    }

    @Override
    public RegistroUtilizacaoAmbienteDTO create(RegistroUtilizacaoAmbienteCreateDTO dto) {
        RegistroUtilizacaoAmbiente entity = toEntity(dto);

        // Busca e associa as entidades relacionadas
        entity.setUsuarioRetirada(usuarioRepository.findById(dto.getUsuarioRetiradaId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario not found: " + dto.getUsuarioRetiradaId())));

        if (dto.getUsuarioDevolucaoId() != null) {
            entity.setUsuarioDevolucao(usuarioRepository.findById(dto.getUsuarioDevolucaoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Usuario not found: " + dto.getUsuarioDevolucaoId())));
        }

        entity.setAmbiente(ambienteRepository.findById(dto.getAmbienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Ambiente not found: " + dto.getAmbienteId())));

        entity.setPlanejamentoAlocacao(planejamentoAlocacaoRepository.findById(dto.getPlanejamentoAlocacaoId())
                .orElseThrow(() -> new ResourceNotFoundException("PlanejamentoAlocacao not found: " + dto.getPlanejamentoAlocacaoId())));

        RegistroUtilizacaoAmbiente saved = repository.save(entity);
        return toDto(saved);
    }

    @Override
    public RegistroUtilizacaoAmbienteDTO update(Long id, RegistroUtilizacaoAmbienteCreateDTO dto) {
        RegistroUtilizacaoAmbiente entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RegistroUtilizacaoAmbiente not found: " + id));

        // Mapeia os campos do DTO para a entidade existente
        modelMapper.map(dto, entity);

        // Atualiza as entidades relacionadas se os IDs foram fornecidos no DTO
        if (dto.getUsuarioRetiradaId() != null) {
            entity.setUsuarioRetirada(usuarioRepository.findById(dto.getUsuarioRetiradaId())
                    .orElseThrow(() -> new ResourceNotFoundException("Usuario not found: " + dto.getUsuarioRetiradaId())));
        }

        if (dto.getUsuarioDevolucaoId() != null) {
            entity.setUsuarioDevolucao(usuarioRepository.findById(dto.getUsuarioDevolucaoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Usuario not found: " + dto.getUsuarioDevolucaoId())));
        }

        if (dto.getAmbienteId() != null) {
            entity.setAmbiente(ambienteRepository.findById(dto.getAmbienteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Ambiente not found: " + dto.getAmbienteId())));
        }

        if (dto.getPlanejamentoAlocacaoId() != null) {
            entity.setPlanejamentoAlocacao(planejamentoAlocacaoRepository.findById(dto.getPlanejamentoAlocacaoId())
                    .orElseThrow(() -> new ResourceNotFoundException("PlanejamentoAlocacao not found: " + dto.getPlanejamentoAlocacaoId())));
        }

        RegistroUtilizacaoAmbiente updated = repository.save(entity);
        return toDto(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("RegistroUtilizacaoAmbiente not found: " + id);
        }
        repository.deleteById(id);
    }
}