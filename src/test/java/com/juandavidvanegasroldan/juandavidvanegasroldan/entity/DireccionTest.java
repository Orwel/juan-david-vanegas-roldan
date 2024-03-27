package com.juandavidvanegasroldan.juandavidvanegasroldan.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DireccionTest {
    @Test
    public void testGetterSetter() {
        // Crear una instancia de Direccion
        Direccion direccion = new Direccion();

        // Establecer valores
        direccion.setIdDireccion(1L);
        direccion.setDireccion("123 Calle Principal");
        direccion.setCiudad("Ciudad Principal");
        direccion.setPais("País Principal");

        // Verificar los valores
        assertEquals(1L, direccion.getIdDireccion());
        assertEquals("123 Calle Principal", direccion.getDireccion());
        assertEquals("Ciudad Principal", direccion.getCiudad());
        assertEquals("País Principal", direccion.getPais());
    }

}