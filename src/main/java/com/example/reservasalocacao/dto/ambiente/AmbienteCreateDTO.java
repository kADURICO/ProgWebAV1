package com.example.reservasalocacao.dto.ambiente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AmbienteCreateDTO {
    @NotBlank(message = "A descrição é obrigatória")
    @Size(max = 400, message = "A descrição deve ter no máximo 400 caracteres")
    private String descricao;

    @NotNull(message = "O andar é obrigatório")
    private Integer andar;

    @NotBlank(message = "O tipo é obrigatório")
    @Size(max = 45, message = "O tipo deve ter no máximo 45 caracteres")
    private String tipo;

    @NotNull(message = "O número de PCs é obrigatório")
    private Integer numeroPcs;

    @NotNull(message = "A capacidade é obrigatória")
    private Integer capacidade;

    @NotNull(message = "O status é obrigatório")
    private Integer status;

    // getters and setters
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Integer getAndar() { return andar; }
    public void setAndar(Integer andar) { this.andar = andar; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Integer getNumeroPcs() { return numeroPcs; }
    public void setNumeroPcs(Integer numeroPcs) { this.numeroPcs = numeroPcs; }
    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
}