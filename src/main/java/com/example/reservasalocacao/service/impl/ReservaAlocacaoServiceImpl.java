package com.example.reservasalocacao.service.impl;

import com.example.reservasalocacao.dto.reservaalocacao.ReservaAlocacaoDTO;
import com.example.reservasalocacao.dto.reservaalocacao.ReservaAlocacaoCreateDTO;
import com.example.reservasalocacao.entity.ReservaAlocacao;
import com.example.reservasalocacao.entity.Usuario;
import com.example.reservasalocacao.exception.ResourceNotFoundException;
import com.example.reservasalocacao.repository.ReservaAlocacaoRepository;
import com.example.reservasalocacao.repository.UsuarioRepository;
import com.example.reservasalocacao.service.ReservaAlocacaoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReservaAlocacaoServiceImpl implements ReservaAlocacaoService {

    private final ReservaAlocacaoRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    public ReservaAlocacaoServiceImpl(ReservaAlocacaoRepository repository, UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    private ReservaAlocacaoDTO toDto(ReservaAlocacao e) {
        return modelMapper.map(e, ReservaAlocacaoDTO.class);
    }

    @Override
    public List<ReservaAlocacaoDTO> findAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ReservaAlocacaoDTO findById(Long id) {
        ReservaAlocacao e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ReservaAlocacao not found: " + id));
        return toDto(e);
    }

    @Override
    public ReservaAlocacaoDTO create(ReservaAlocacaoCreateDTO dto) {
        ReservaAlocacao entity = new ReservaAlocacao();

        // 1. Busca a entidade Usuario com base no ID fornecido no DTO
        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario not found: " + dto.getIdUsuario()));

        // 2. Mapeia os campos do DTO para a entidade
        modelMapper.map(dto, entity);

        // 3. Define o objeto Usuario na entidade
        entity.setUsuario(usuario);

        ReservaAlocacao saved = repository.save(entity);
        return toDto(saved);
    }

    @Override
    public ReservaAlocacaoDTO update(Long id, ReservaAlocacaoCreateDTO dto) {
        ReservaAlocacao entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ReservaAlocacao not found: " + id));

        // Mapeia os campos atualizáveis do DTO para a entidade existente
        modelMapper.map(dto, entity);

        ReservaAlocacao updated = repository.save(entity);
        return toDto(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ReservaAlocacao not found: " + id);
        }
        repository.deleteById(id);
    }
}