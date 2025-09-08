package com.example.reservasalocacao.controller;

import com.example.reservasalocacao.dto.reservaalocacao.ReservaAlocacaoDTO;
import com.example.reservasalocacao.dto.reservaalocacao.ReservaAlocacaoCreateDTO;
import com.example.reservasalocacao.service.ReservaAlocacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservaalocacaos")
public class ReservaAlocacaoController {

    private final ReservaAlocacaoService service;

    public ReservaAlocacaoController(ReservaAlocacaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ReservaAlocacaoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaAlocacaoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ReservaAlocacaoDTO> create(@Valid @RequestBody ReservaAlocacaoCreateDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaAlocacaoDTO> update(@PathVariable Long id, @Valid @RequestBody ReservaAlocacaoCreateDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
