package com.example.reservasalocacao.dto.ambiente;

public class AmbienteDTO {
    private Long id;
    private String descricao;
    private Integer andar;
    private String tipo;
    private Integer numeroPcs;
    private Integer capacidade;
    private Integer status;

    // getters and setters
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