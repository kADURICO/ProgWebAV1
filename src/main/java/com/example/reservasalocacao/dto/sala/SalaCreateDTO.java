package com.example.reservasalocacao.dto.sala;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SalaCreateDTO {

    @NotBlank(message = "O bloco é obrigatório")
    @Size(max = 255, message = "O bloco deve ter no máximo 255 caracteres")
    private String bloco;

    @NotNull(message = "A capacidade é obrigatória")
    private Integer capacidade;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 255, message = "O nome deve ter no máximo 255 caracteres")
    private String nome;

    // getters and setters
    public String getBloco() {
        return bloco;
    }
    public void setBloco(String bloco) {
        this.bloco = bloco;
    }
    public Integer getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}