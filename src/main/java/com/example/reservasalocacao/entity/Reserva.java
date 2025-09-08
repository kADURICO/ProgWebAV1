package com.example.reservasalocacao.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inicio")
    private LocalDateTime inicio;

    @Column(name = "fim")
    private LocalDateTime fim;

    @Column(name = "reservado_para", length = 255)
    private String reservadoPara;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sala_id")
    private Sala sala;

    @Column(name = "tempo")
    private LocalDateTime tempo;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getInicio() { return inicio; }
    public void setInicio(LocalDateTime inicio) { this.inicio = inicio; }
    public LocalDateTime getFim() { return fim; }
    public void setFim(LocalDateTime fim) { this.fim = fim; }
    public String getReservadoPara() { return reservadoPara; }
    public void setReservadoPara(String reservadoPara) { this.reservadoPara = reservadoPara; }
    public Sala getSala() { return sala; }
    public void setSala(Sala sala) { this.sala = sala; }
    public LocalDateTime getTempo() { return tempo; }
    public void setTempo(LocalDateTime tempo) { this.tempo = tempo; }
}
