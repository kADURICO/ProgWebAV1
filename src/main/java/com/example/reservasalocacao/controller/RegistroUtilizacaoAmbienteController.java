package com.example.reservasalocacao.controller;

import com.example.reservasalocacao.dto.registroutilizacaoambiente.RegistroUtilizacaoAmbienteDTO;
import com.example.reservasalocacao.dto.registroutilizacaoambiente.RegistroUtilizacaoAmbienteCreateDTO;
import com.example.reservasalocacao.service.RegistroUtilizacaoAmbienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registroutilizacaoambientes")
public class RegistroUtilizacaoAmbienteController {

    private final RegistroUtilizacaoAmbienteService service;

    public RegistroUtilizacaoAmbienteController(RegistroUtilizacaoAmbienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RegistroUtilizacaoAmbienteDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroUtilizacaoAmbienteDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<RegistroUtilizacaoAmbienteDTO> create(@Valid @RequestBody RegistroUtilizacaoAmbienteCreateDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroUtilizacaoAmbienteDTO> update(@PathVariable Long id, @Valid @RequestBody RegistroUtilizacaoAmbienteCreateDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
