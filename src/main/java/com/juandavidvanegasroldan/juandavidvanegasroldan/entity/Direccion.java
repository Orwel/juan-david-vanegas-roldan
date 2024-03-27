package com.juandavidvanegasroldan.juandavidvanegasroldan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "direccion")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Direccion {

    @OneToOne
    private Paciente paciente;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDireccion;

    private String direccion;
    private String ciudad;
    private String pais;

}
