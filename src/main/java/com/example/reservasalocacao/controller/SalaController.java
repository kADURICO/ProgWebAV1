package com.example.reservasalocacao.controller;

import com.example.reservasalocacao.dto.sala.SalaDTO;
import com.example.reservasalocacao.dto.sala.SalaCreateDTO;
import com.example.reservasalocacao.service.SalaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    private final SalaService service;

    public SalaController(SalaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SalaDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<SalaDTO> create(@Valid @RequestBody SalaCreateDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaDTO> update(@PathVariable Long id, @Valid @RequestBody SalaCreateDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
