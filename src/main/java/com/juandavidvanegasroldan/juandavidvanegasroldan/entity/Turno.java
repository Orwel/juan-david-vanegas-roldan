package com.juandavidvanegasroldan.juandavidvanegasroldan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "turno")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Turno {
    @ManyToOne
    @JoinColumn(name = "odontologo_idOdontologo")
    private Odontologo odontologo;
    @OneToOne
    private Paciente paciente;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTurno;
    private LocalDate fechaYHoraTurno;
}
