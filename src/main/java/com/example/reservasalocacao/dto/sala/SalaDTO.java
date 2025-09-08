package com.example.reservasalocacao.dto.sala;

public class SalaDTO {
    private Long id;
    private String bloco;
    private Integer capacidade;
    private String nome;

    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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