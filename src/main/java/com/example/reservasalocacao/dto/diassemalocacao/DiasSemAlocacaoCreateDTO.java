package com.example.reservasalocacao.dto.diassemalocacao;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

public class DiasSemAlocacaoCreateDTO {

    private LocalDate data;

    private Integer diaSemana;

    @NotNull(message = "O horário de início é obrigatório")
    private LocalTime horarioInicio;

    @NotNull(message = "O horário de fim é obrigatório")
    private LocalTime horarioFim;

    @NotNull(message = "O status é obrigatório")
    private Integer status;

    @NotNull(message = "O ID do ambiente é obrigatório")
    private Long ambienteId;

    // getters and setters
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
    public Long getAmbienteId() {
        return ambienteId;
    }
    public void setAmbienteId(Long ambienteId) {
        this.ambienteId = ambienteId;
    }
}