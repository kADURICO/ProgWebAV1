package com.example.reservasalocacao.dto.reservaalocacao;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaAlocacaoCreateDTO {

    @NotBlank(message = "A justificativa é obrigatória")
    @Size(max = 300, message = "A justificativa deve ter no máximo 300 caracteres")
    private String justificativa;

    @NotNull(message = "A data da reserva é obrigatória")
    @FutureOrPresent(message = "A data deve ser igual ou posterior à data atual")
    private LocalDate data;

    @NotNull(message = "A hora de início é obrigatória")
    private LocalTime horaInicio;

    @NotNull(message = "A hora de fim é obrigatória")
    private LocalTime horaFim;

    @NotNull(message = "O status é obrigatório")
    private Integer status;

    @NotNull(message = "O usuário é obrigatório")
    private Long idUsuario;

    // getters and setters
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
    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
}