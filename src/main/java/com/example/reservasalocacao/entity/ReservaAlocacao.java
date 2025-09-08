package com.example.reservasalocacao.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reserva_alocacao")
public class ReservaAlocacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserva_alocacao_id")
    private Long id;

    @Column(name = "reserva_alocacao_justificativa", length = 300)
    private String justificativa;

    @Column(name = "reserva_alocacao_data")
    private LocalDate data;

    @Column(name = "reserva_alocacao_hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "reserva_alocacao_hora_fim")
    private LocalTime horaFim;

    @Column(name = "reserva_alocacao_status")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getJustificativa() { return justificativa; }
    public void setJustificativa(String justificativa) { this.justificativa = justificativa; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }
    public LocalTime getHoraFim() { return horaFim; }
    public void setHoraFim(LocalTime horaFim) { this.horaFim = horaFim; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
