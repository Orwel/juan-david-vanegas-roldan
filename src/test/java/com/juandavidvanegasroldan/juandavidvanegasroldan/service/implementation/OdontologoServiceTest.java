package com.juandavidvanegasroldan.juandavidvanegasroldan.service.implementation;

import com.juandavidvanegasroldan.juandavidvanegasroldan.entity.Odontologo;
import com.juandavidvanegasroldan.juandavidvanegasroldan.exception.ResourceNotFoundException;
import com.juandavidvanegasroldan.juandavidvanegasroldan.repository.IOdontologoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OdontologoServiceTest {

    private OdontologoService odontologoService;
    private IOdontologoRepository odontologoRepository;

    @BeforeEach
    void setUp() {
        odontologoRepository = Mockito.mock(IOdontologoRepository.class);
        odontologoService = new OdontologoService(odontologoRepository);

        // Configuración del comportamiento simulado para findById()
        when(odontologoRepository.findById(anyLong())).thenReturn(Optional.empty());
    }


    @Test
    void guardarOdontologo() {
        // Arrange
        Odontologo odontologo = new Odontologo();
        when(odontologoRepository.save(odontologo)).thenReturn(odontologo);

        // Act
        Odontologo odontologoGuardado = odontologoService.guardarOdontologo(odontologo);

        // Assert
        assertEquals(odontologo, odontologoGuardado);
    }

    @Test
    void listarTodosOdontologos() {
        // Arrange
        List<Odontologo> odontologos = new ArrayList<>();
        odontologos.add(new Odontologo());
        odontologos.add(new Odontologo());
        when(odontologoRepository.findAll()).thenReturn(odontologos);

        // Act
        List<Odontologo> resultado = odontologoService.listarTodosOdontologos();

        // Assert
        assertEquals(2, resultado.size());
    }

    @Test
    void buscarPorIdOdontologo_DeberiaLanzarExcepcionCuandoNoSeEncuentraElOdontologo() {
        // Arrange
        when(odontologoRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Act y Assert
        assertThrows(ResourceNotFoundException.class, () -> odontologoService.buscarPorIdOdontologo(1L));
    }

    @Test
    void buscarPorIdOdontologo_DeberiaRetornarOdontologoCuandoSeEncuentra() {
        // Arrange
        Odontologo odontologo = new Odontologo();
        odontologo.setIdOdontologo(1L);
        when(odontologoRepository.findById(anyLong())).thenReturn(Optional.of(odontologo));

        // Act
        Odontologo resultado = odontologoService.buscarPorIdOdontologo(1L);

        // Assert
        assertNotNull(resultado);
        assertEquals(1L, resultado.getIdOdontologo());
    }

}
