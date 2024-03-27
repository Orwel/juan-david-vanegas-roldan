package com.juandavidvanegasroldan.juandavidvanegasroldan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "odontologos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idOdontologo")
    private Long idOdontologo;
    @Column(name = "nombreOdontologo")
    private String nombreOdontologo;
    @Column(name = "apellidoOdontologo")
    private String apellidoOdontologo;
    @Column(name = "matriculaOdontologo")
    private String matriculaOdontologo;

    @OneToMany(mappedBy = "odontologo")
    private Set<Turno> turnoSet = new HashSet<>();


}
