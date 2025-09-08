package com.example.reservasalocacao.dto.planejamentoalocacao;

import com.example.reservasalocacao.dto.ambiente.AmbienteDTO;
import com.example.reservasalocacao.dto.usuario.UsuarioDTO;
import com.example.reservasalocacao.dto.reservaalocacao.ReservaAlocacaoDTO;
import java.time.LocalDate;
import java.time.LocalTime;

public class PlanejamentoAlocacaoDTO {
    private Long id;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private String observacao;
    private Integer status;
    private AmbienteDTO ambiente;
    private UsuarioDTO usuario;
    private ReservaAlocacaoDTO reservaAlocacao;

    // getters and setters
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
    public AmbienteDTO getAmbiente() { return ambiente; }
    public void setAmbiente(AmbienteDTO ambiente) { this.ambiente = ambiente; }
    public UsuarioDTO getUsuario() { return usuario; }
    public void setUsuario(UsuarioDTO usuario) { this.usuario = usuario; }
    public ReservaAlocacaoDTO getReservaAlocacao() { return reservaAlocacao; }
    public void setReservaAlocacao(ReservaAlocacaoDTO reservaAlocacao) { this.reservaAlocacao = reservaAlocacao; }
}