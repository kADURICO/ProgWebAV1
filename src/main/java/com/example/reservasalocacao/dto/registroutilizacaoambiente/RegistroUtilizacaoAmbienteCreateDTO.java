package com.example.reservasalocacao.dto.registroutilizacaoambiente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class RegistroUtilizacaoAmbienteCreateDTO {

    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    @NotNull(message = "O status é obrigatório")
    private Integer status;

    @Size(max = 400, message = "A observação deve ter no máximo 400 caracteres")
    private String observacao;

    @NotNull(message = "O ID do planejamento de alocação é obrigatório")
    private Long planejamentoAlocacaoId;

    @NotNull(message = "O ID do usuário de retirada é obrigatório")
    private Long usuarioRetiradaId;

    private Long usuarioDevolucaoId; // Pode ser nulo, pois a devolução pode ser feita depois

    @NotNull(message = "O ID do ambiente é obrigatório")
    private Long ambienteId;

    // getters and setters
    public LocalDateTime getHoraEntrada() { return horaEntrada; }
    public void setHoraEntrada(LocalDateTime horaEntrada) { this.horaEntrada = horaEntrada; }
    public LocalDateTime getHoraSaida() { return horaSaida; }
    public void setHoraSaida(LocalDateTime horaSaida) { this.horaSaida = horaSaida; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }
    public Long getPlanejamentoAlocacaoId() { return planejamentoAlocacaoId; }
    public void setPlanejamentoAlocacaoId(Long planejamentoAlocacaoId) { this.planejamentoAlocacaoId = planejamentoAlocacaoId; }
    public Long getUsuarioRetiradaId() { return usuarioRetiradaId; }
    public void setUsuarioRetiradaId(Long usuarioRetiradaId) { this.usuarioRetiradaId = usuarioRetiradaId; }
    public Long getUsuarioDevolucaoId() { return usuarioDevolucaoId; }
    public void setUsuarioDevolucaoId(Long usuarioDevolucaoId) { this.usuarioDevolucaoId = usuarioDevolucaoId; }
    public Long getAmbienteId() { return ambienteId; }
    public void setAmbienteId(Long ambienteId) { this.ambienteId = ambienteId; }
}