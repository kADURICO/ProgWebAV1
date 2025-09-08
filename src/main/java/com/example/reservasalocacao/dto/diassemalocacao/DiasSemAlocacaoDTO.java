package com.example.reservasalocacao.dto.diassemalocacao;

import com.example.reservasalocacao.dto.ambiente.AmbienteDTO;
import java.time.LocalDate;
import java.time.LocalTime;

public class DiasSemAlocacaoDTO {
    private Long id;
    private LocalDate data;
    private Integer diaSemana;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;
    private Integer status;
    private AmbienteDTO ambiente;

    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public Integer getDiaSemana() {
        return diaSemana;
    }
    public void setDiaSemana(Integer diaSemana) {
        this.diaSemana = diaSemana;
    }
    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }
    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }
    public LocalTime getHorarioFim() {
        return horarioFim;
    }
    public void setHorarioFim(LocalTime horarioFim) {
        this.horarioFim = horarioFim;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public AmbienteDTO getAmbiente() {
        return ambiente;
    }
    public void setAmbiente(AmbienteDTO ambiente) {
        this.ambiente = ambiente;
    }
}