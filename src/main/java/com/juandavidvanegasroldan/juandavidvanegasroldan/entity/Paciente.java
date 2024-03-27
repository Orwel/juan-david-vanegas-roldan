package com.juandavidvanegasroldan.juandavidvanegasroldan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import java.time.LocalDate;
@Entity
@Table(name = "paciente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPaciente")
    private Long idPaciente;
    @Column(name = "nombrePaciente")
    private String nombrePaciente;
    @Column(name = "apellidoPaciente")
    private String apellidoPaciente;
    @Column(name = "DNIPaciente")
    private Integer DNIPaciente;
    @Column(name = "fechaAlta")
    private LocalDate fechaAlta;
    @Column(name = "fechaBaja")
    private LocalDate fechaBaja;

    @OneToOne(mappedBy = "paciente")
    private Direccion direccion;

    @OneToMany(mappedBy = "paciente")  // Cambiado a OneToMany
    private Set<Turno> turnos = new HashSet<>();  // Cambiado a Set<Turno>
}
