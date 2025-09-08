package com.example.reservasalocacao.service;

import com.example.reservasalocacao.dto.usuario.UsuarioDTO;
import com.example.reservasalocacao.dto.usuario.UsuarioCreateDTO;
import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> findAll();
    UsuarioDTO findById(Long id);
    UsuarioDTO create(UsuarioCreateDTO dto);
    UsuarioDTO update(Long id, UsuarioCreateDTO dto);
    void delete(Long id);
}
