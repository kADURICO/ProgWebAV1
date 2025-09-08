package com.example.reservasalocacao.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "dias_sem_alocacao")
public class DiasSemAlocacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dias_sem_alocacao_id")
    private Long id;

    @Column(name = "dias_sem_alocacao_data")
    private LocalDate data;

    @Column(name = "dias_sem_alocacao_dia_semana")
    private Integer diaSemana;

    @Column(name = "dias_sem_alocacao_horario_inicio")
    private LocalTime horarioInicio;

    @Column(name = "dias_sem_alocacao_horario_fim")
    private LocalTime horarioFim;

    @Column(name = "dias_sem_alocacao_status")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ambiente_id")
    private Ambiente ambiente;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    public Integer getDiaSemana() { return diaSemana; }
    public void setDiaSemana(Integer diaSemana) { this.diaSemana = diaSemana; }
    public LocalTime getHorarioInicio() { return horarioInicio; }
    public void setHorarioInicio(LocalTime horarioInicio) { this.horarioInicio = horarioInicio; }
    public LocalTime getHorarioFim() { return horarioFim; }
    public void setHorarioFim(LocalTime horarioFim) { this.horarioFim = horarioFim; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public Ambiente getAmbiente() { return ambiente; }
    public void setAmbiente(Ambiente ambiente) { this.ambiente = ambiente; }
}
