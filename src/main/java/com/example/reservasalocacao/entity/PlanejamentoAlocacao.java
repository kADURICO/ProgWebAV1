package com.example.reservasalocacao.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "planejamento_alocacao")
public class PlanejamentoAlocacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planejamento_alocacao_id")
    private Long id;

    @Column(name = "planejamento_alocacao_data")
    private LocalDate data;

    @Column(name = "planejamento_alocacao_hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "planejamento_alocacao_hora_fim")
    private LocalTime horaFim;

    @Column(name = "planejamento_alocacao_observacao", length = 300)
    private String observacao;

    @Column(name = "planejamento_alocacao_status")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ambiente_id")
    private Ambiente ambiente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserva_alocacao_id")
    private ReservaAlocacao reservaAlocacao;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }
    public LocalTime getHoraFim() { return horaFim; }
    public void setHoraFim(LocalTime horaFim) { this.horaFim = horaFim; }
    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public Ambiente getAmbiente() { return ambiente; }
    public void setAmbiente(Ambiente ambiente) { this.ambiente = ambiente; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public ReservaAlocacao getReservaAlocacao() { return reservaAlocacao; }
    public void setReservaAlocacao(ReservaAlocacao reservaAlocacao) { this.reservaAlocacao = reservaAlocacao; }
}
