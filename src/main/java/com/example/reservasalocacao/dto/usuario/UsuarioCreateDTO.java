package com.example.reservasalocacao.dto.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UsuarioCreateDTO {

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 300, message = "O nome deve ter no máximo 300 caracteres")
    private String nome;

    @Size(max = 45, message = "A matrícula deve ter no máximo 45 caracteres")
    private String matricula;

    @NotNull(message = "O tipo é obrigatório")
    private Integer tipo;

    @NotNull(message = "O status é obrigatório")
    private Integer status;

    private Long idResponsavel;

    // getters and setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public Integer getTipo() {
        return tipo;
    }
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Long getIdResponsavel() {
        return idResponsavel;
    }
    public void setIdResponsavel(Long idResponsavel) {
        this.idResponsavel = idResponsavel;
    }
}