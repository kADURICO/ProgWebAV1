package com.example.reservasalocacao.dto.registroutilizacaoambiente;

import com.example.reservasalocacao.dto.usuario.UsuarioDTO;
import com.example.reservasalocacao.dto.ambiente.AmbienteDTO;
import com.example.reservasalocacao.dto.planejamentoalocacao.PlanejamentoAlocacaoDTO;
import java.time.LocalDateTime;

public class RegistroUtilizacaoAmbienteDTO {
    private Long id;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    private Integer status;
    private String observacao;
    private PlanejamentoAlocacaoDTO planejamentoAlocacao;
    private UsuarioDTO usuarioRetirada;
    private UsuarioDTO usuarioDevolucao;
    private AmbienteDTO ambiente;

    // getters and setters
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
    public PlanejamentoAlocacaoDTO getPlanejamentoAlocacao() { return planejamentoAlocacao; }
    public void setPlanejamentoAlocacao(PlanejamentoAlocacaoDTO planejamentoAlocacao) { this.planejamentoAlocacao = planejamentoAlocacao; }
    public UsuarioDTO getUsuarioRetirada() { return usuarioRetirada; }
    public void setUsuarioRetirada(UsuarioDTO usuarioRetirada) { this.usuarioRetirada = usuarioRetirada; }
    public UsuarioDTO getUsuarioDevolucao() { return usuarioDevolucao; }
    public void setUsuarioDevolucao(UsuarioDTO usuarioDevolucao) { this.usuarioDevolucao = usuarioDevolucao; }
    public AmbienteDTO getAmbiente() { return ambiente; }
    public void setAmbiente(AmbienteDTO ambiente) { this.ambiente = ambiente; }
}