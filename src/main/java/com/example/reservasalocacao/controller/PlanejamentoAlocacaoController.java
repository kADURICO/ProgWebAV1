package com.example.reservasalocacao.controller;

import com.example.reservasalocacao.dto.planejamentoalocacao.PlanejamentoAlocacaoDTO;
import com.example.reservasalocacao.dto.planejamentoalocacao.PlanejamentoAlocacaoCreateDTO;
import com.example.reservasalocacao.service.PlanejamentoAlocacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planejamentoalocacaos")
public class PlanejamentoAlocacaoController {

    private final PlanejamentoAlocacaoService service;

    public PlanejamentoAlocacaoController(PlanejamentoAlocacaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PlanejamentoAlocacaoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanejamentoAlocacaoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<PlanejamentoAlocacaoDTO> create(@Valid @RequestBody PlanejamentoAlocacaoCreateDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanejamentoAlocacaoDTO> update(@PathVariable Long id, @Valid @RequestBody PlanejamentoAlocacaoCreateDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
