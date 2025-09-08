package com.example.reservasalocacao.controller;

import com.example.reservasalocacao.dto.diassemalocacao.DiasSemAlocacaoDTO;
import com.example.reservasalocacao.dto.diassemalocacao.DiasSemAlocacaoCreateDTO;
import com.example.reservasalocacao.service.DiasSemAlocacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diassemalocacaos")
public class DiasSemAlocacaoController {

    private final DiasSemAlocacaoService service;

    public DiasSemAlocacaoController(DiasSemAlocacaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DiasSemAlocacaoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiasSemAlocacaoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<DiasSemAlocacaoDTO> create(@Valid @RequestBody DiasSemAlocacaoCreateDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiasSemAlocacaoDTO> update(@PathVariable Long id, @Valid @RequestBody DiasSemAlocacaoCreateDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
