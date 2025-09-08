package com.example.reservasalocacao.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sala")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bloco", length = 255)
    private String bloco;

    @Column(name = "capacidade")
    private Integer capacidade;

    @Column(name = "nome", length = 255)
    private String nome;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getBloco() { return bloco; }
    public void setBloco(String bloco) { this.bloco = bloco; }
    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
