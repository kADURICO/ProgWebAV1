package com.example.reservasalocacao.dto.planejamentoalocacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;

public class PlanejamentoAlocacaoCreateDTO {

    @NotNull(message = "A data é obrigatória")
    private LocalDate data;

    @NotNull(message = "A hora de início é obrigatória")
    private LocalTime horaInicio;

    @NotNull(message = "A hora de fim é obrigatória")
    private LocalTime horaFim;

    @Size(max = 300, message = "A observação deve ter no máximo 300 caracteres")
    private String observacao;

    @NotNull(message = "O status é obrigatório")
    private Integer status;

    @NotNull(message = "O ID do ambiente é obrigatório")
    private Long ambienteId;

    @NotNull(message = "O ID do usuário é obrigatório")
    private Long usuarioId;

    private Long reservaAlocacaoId;

    // getters and setters
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
    public Long getAmbienteId() { return ambienteId; }
    public void setAmbienteId(Long ambienteId) { this.ambienteId = ambienteId; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getReservaAlocacaoId() { return reservaAlocacaoId; }
    public void setReservaAlocacaoId(Long reservaAlocacaoId) { this.reservaAlocacaoId = reservaAlocacaoId; }
}