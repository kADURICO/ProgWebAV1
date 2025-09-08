package com.example.reservasalocacao.controller;

import com.example.reservasalocacao.dto.ambiente.AmbienteDTO;
import com.example.reservasalocacao.dto.ambiente.AmbienteCreateDTO;
import com.example.reservasalocacao.service.AmbienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ambientes")
public class AmbienteController {

    private final AmbienteService service;

    public AmbienteController(AmbienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AmbienteDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AmbienteDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<AmbienteDTO> create(@Valid @RequestBody AmbienteCreateDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AmbienteDTO> update(@PathVariable Long id, @Valid @RequestBody AmbienteCreateDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
