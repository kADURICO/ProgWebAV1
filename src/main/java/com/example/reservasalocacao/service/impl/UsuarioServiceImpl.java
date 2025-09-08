package com.example.reservasalocacao.service.impl;

import com.example.reservasalocacao.dto.usuario.UsuarioDTO;
import com.example.reservasalocacao.dto.usuario.UsuarioCreateDTO;
import com.example.reservasalocacao.entity.Usuario;
import com.example.reservasalocacao.exception.ResourceNotFoundException;
import com.example.reservasalocacao.repository.UsuarioRepository;
import com.example.reservasalocacao.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final ModelMapper modelMapper;

    public UsuarioServiceImpl(UsuarioRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    private UsuarioDTO toDto(Usuario e) {
        return modelMapper.map(e, UsuarioDTO.class);
    }

    private Usuario toEntity(UsuarioCreateDTO dto) {
        return modelMapper.map(dto, Usuario.class);
    }

    @Override
    public List<UsuarioDTO> findAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO findById(Long id) {
        Usuario e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario not found: " + id));
        return toDto(e);
    }

    @Override
    public UsuarioDTO create(UsuarioCreateDTO dto) {
        Usuario entity = toEntity(dto);
        entity.setDataCriacao(LocalDateTime.now());

        // Mapeamento do Responsável
        if (dto.getIdResponsavel() != null) {
            Usuario responsavel = repository.findById(dto.getIdResponsavel())
                    .orElseThrow(() -> new ResourceNotFoundException("Responsavel not found: " + dto.getIdResponsavel()));
            entity.setResponsavel(responsavel);
        }

        Usuario saved = repository.save(entity);
        return toDto(saved);
    }

    @Override
    public UsuarioDTO update(Long id, UsuarioCreateDTO dto) {
        Usuario entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario not found: " + id));

        // Mapeamento dos campos do DTO para a Entidade existente
        modelMapper.map(dto, entity);

        // Mapeamento do Responsável (se for alterado)
        if (dto.getIdResponsavel() != null) {
            Usuario responsavel = repository.findById(dto.getIdResponsavel())
                    .orElseThrow(() -> new ResourceNotFoundException("Responsavel not found: " + dto.getIdResponsavel()));
            entity.setResponsavel(responsavel);
        }

        Usuario updated = repository.save(entity);
        return toDto(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) throw new ResourceNotFoundException("Usuario not found: " + id);
        repository.deleteById(id);
    }
}