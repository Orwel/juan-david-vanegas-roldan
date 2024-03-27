package com.juandavidvanegasroldan.juandavidvanegasroldan.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

class OdontologoTest {

    @Test
    public void testGetterSetter() {
        // Crear una instancia de Odontologo
        Odontologo odontologo = new Odontologo();

        // Establecer valores
        odontologo.setIdOdontologo(1L);
        odontologo.setNombreOdontologo("Juan");
        odontologo.setApellidoOdontologo("Perez");
        odontologo.setMatriculaOdontologo("ABC123");

        // Verificar los valores
        assertEquals(1L, odontologo.getIdOdontologo());
        assertEquals("Juan", odontologo.getNombreOdontologo());
        assertEquals("Perez", odontologo.getApellidoOdontologo());
        assertEquals("ABC123", odontologo.getMatriculaOdontologo());
    }

    @Test
    public void testTurnoSet() {
        // Crear una instancia de Odontologo
        Odontologo odontologo = new Odontologo();

        // Crear un turno
        Turno turno = new Turno();

        // Agregar el turno al conjunto de turnos del odontologo
        odontologo.getTurnoSet().add(turno);

        // Verificar que el conjunto de turnos contenga el turno agregado
        assertTrue(odontologo.getTurnoSet().contains(turno));
    }

    // Puedes agregar más pruebas según sea necesario para cubrir otros métodos o comportamientos de la clase Odontologo
}
