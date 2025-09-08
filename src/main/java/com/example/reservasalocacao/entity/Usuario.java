package com.example.reservasalocacao.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    @Column(name = "usuario_nome", length = 300, nullable = false)
    private String nome;

    @Column(name = "usuario_matricula", length = 45)
    private String matricula;

    @Column(name = "usuario_tipo")
    private Integer tipo;

    @Column(name = "usuario_status")
    private Integer status;

    @Column(name = "usuario_log_data_criacao")
    private LocalDateTime dataCriacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id_responsavel_id")
    private Usuario responsavel;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public Integer getTipo() { return tipo; }
    public void setTipo(Integer tipo) { this.tipo = tipo; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
    public Usuario getResponsavel() { return responsavel; }
    public void setResponsavel(Usuario responsavel) { this.responsavel = responsavel; }
}
