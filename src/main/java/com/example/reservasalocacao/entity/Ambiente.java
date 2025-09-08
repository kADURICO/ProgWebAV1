package com.example.reservasalocacao.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ambiente")
public class Ambiente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ambiente_id")
    private Long id;

    @Column(name = "ambiente_descricao", length = 400)
    private String descricao;

    @Column(name = "ambiente_andar")
    private Integer andar;

    @Column(name = "ambiente_tipo", length = 45)
    private String tipo;

    @Column(name = "ambiente_numero_pcs")
    private Integer numeroPcs;

    @Column(name = "ambiente_capacidade")
    private Integer capacidade;

    @Column(name = "ambiente_status")
    private Integer status;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
