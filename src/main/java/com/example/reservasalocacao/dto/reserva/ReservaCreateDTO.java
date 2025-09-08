package com.example.reservasalocacao.dto.reserva;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class ReservaCreateDTO {

    @NotNull(message = "O campo de início é obrigatório")
    private LocalDateTime inicio;

    @NotNull(message = "O campo de fim é obrigatório")
    private LocalDateTime fim;

    @NotBlank(message = "O campo 'reservadoPara' é obrigatório")
    @Size(max = 255, message = "O campo 'reservadoPara' deve ter no máximo 255 caracteres")
    private String reservadoPara;

    @NotNull(message = "O campo 'tempo' é obrigatório")
    private LocalDateTime tempo;

    @NotNull(message = "O ID da sala é obrigatório")
    private Long salaId;

    // getters and setters
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

    public LocalDateTime getTempo() {
        return tempo;
    }

    public void setTempo(LocalDateTime tempo) {
        this.tempo = tempo;
    }

    public Long getSalaId() {
        return salaId;
    }

    public void setSalaId(Long salaId) {
        this.salaId = salaId;
    }
}