package com.example.reservasalocacao.dto.reserva;

import com.example.reservasalocacao.dto.sala.SalaDTO;

import java.time.LocalDateTime;

public class ReservaDTO {
    private Long id;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private String reservadoPara;
    private SalaDTO sala;
    private LocalDateTime tempo;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public String getReservadoPara() {
        return reservadoPara;
    }

    public void setReservadoPara(String reservadoPara) {
        this.reservadoPara = reservadoPara;
    }

    public SalaDTO getSala() {
        return sala;
    }

    public void setSala(SalaDTO sala) {
        this.sala = sala;
    }

    public LocalDateTime getTempo() {
        return tempo;
    }

    public void setTempo(LocalDateTime tempo) {
        this.tempo = tempo;
    }
}