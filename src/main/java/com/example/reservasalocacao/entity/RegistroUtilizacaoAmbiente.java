package com.example.reservasalocacao.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "registro_utilizacao_ambiente")
public class RegistroUtilizacaoAmbiente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registro_utilizacao_ambiente_id")
    private Long id;

    @Column(name = "registro_utilizacao_ambiente_hora_entrada")
    private LocalDateTime horaEntrada;

    @Column(name = "registro_utilizacao_ambiente_hora_saida")
    private LocalDateTime horaSaida;

    @Column(name = "registro_utilizacao_ambiente_status")
    private Integer status;

    @Column(name = "registro_utilizacao_ambiente_observacao", length = 400)
    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planejamento_alocacao_id")
    private PlanejamentoAlocacao planejamentoAlocacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id_retirada")
    private Usuario usuarioRetirada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id_devolucao")
    private Usuario usuarioDevolucao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ambiente_id")
    private Ambiente ambiente;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getHoraEntrada() { return horaEntrada; }
    public void setHoraEntrada(LocalDateTime horaEntrada) { this.horaEntrada = horaEntrada; }
    public LocalDateTime getHoraSaida() { return horaSaida; }
    public void setHoraSaida(LocalDateTime horaSaida) { this.horaSaida = horaSaida; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }
    public PlanejamentoAlocacao getPlanejamentoAlocacao() { return planejamentoAlocacao; }
    public void setPlanejamentoAlocacao(PlanejamentoAlocacao planejamentoAlocacao) { this.planejamentoAlocacao = planejamentoAlocacao; }
    public Usuario getUsuarioRetirada() { return usuarioRetirada; }
    public void setUsuarioRetirada(Usuario usuarioRetirada) { this.usuarioRetirada = usuarioRetirada; }
    public Usuario getUsuarioDevolucao() { return usuarioDevolucao; }
    public void setUsuarioDevolucao(Usuario usuarioDevolucao) { this.usuarioDevolucao = usuarioDevolucao; }
    public Ambiente getAmbiente() { return ambiente; }
    public void setAmbiente(Ambiente ambiente) { this.ambiente = ambiente; }
}
