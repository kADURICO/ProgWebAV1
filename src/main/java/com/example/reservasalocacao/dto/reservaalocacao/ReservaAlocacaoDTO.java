package com.example.reservasalocacao.dto.reservaalocacao;

import com.example.reservasalocacao.dto.usuario.UsuarioDTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaAlocacaoDTO {
    private Long id;
    private String justificativa;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private Integer status;
    private UsuarioDTO usuario;

    // getters and setters
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
    public UsuarioDTO getUsuario() { return usuario; }
    public void setUsuario(UsuarioDTO usuario) { this.usuario = usuario; }
}