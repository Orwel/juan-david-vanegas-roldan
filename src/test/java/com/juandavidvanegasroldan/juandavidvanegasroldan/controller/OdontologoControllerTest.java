package com.juandavidvanegasroldan.juandavidvanegasroldan.controller;

import com.juandavidvanegasroldan.juandavidvanegasroldan.entity.Odontologo;
import com.juandavidvanegasroldan.juandavidvanegasroldan.exception.ResourceNotFoundException;
import com.juandavidvanegasroldan.juandavidvanegasroldan.service.IOdontologoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class OdontologoControllerTest {

    @Mock
    private IOdontologoService odontologoService;

    @InjectMocks
    private OdontologoController odontologoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void buscarPorId_DeberiaRetornarOdontologoExistente() {
        // Arrange
        Long id = 1L;
        Odontologo odontologo = new Odontologo();
        odontologo.setIdOdontologo(id);
        when(odontologoService.buscarPorIdOdontologo(id)).thenReturn(odontologo);

        // Act
        ResponseEntity<Odontologo> response = odontologoController.buscarPorId(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(odontologo, response.getBody());
    }

    @Test
    void buscarPorId_DeberiaLanzarExcepcionCuandoOdontologoNoExiste() {
        // Arrange
        Long idNoExistente = 999L;

        // Set up the mocked service to throw a ResourceNotFoundException
        when(odontologoService.buscarPorIdOdontologo(idNoExistente))
                .thenThrow(new ResourceNotFoundException("Odontólogo no encontrado con id: " + idNoExistente));

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> odontologoController.buscarPorId(idNoExistente));

        // Verify
        verify(odontologoService, times(1)).buscarPorIdOdontologo(idNoExistente);
    }


    @Test
    void guardar_DeberiaGuardarOdontologo() {
        // Arrange
        Odontologo odontologo = new Odontologo();
        when(odontologoService.guardarOdontologo(any(Odontologo.class))).thenReturn(odontologo);

        // Act
        ResponseEntity<Odontologo> response = odontologoController.guardar(odontologo);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(odontologo, response.getBody());
    }

    @Test
    void listarTodos_DeberiaRetornarListaDeOdontologos() {
        // Arrange
        List<Odontologo> odontologos = Arrays.asList(new Odontologo(), new Odontologo());
        when(odontologoService.listarTodosOdontologos()).thenReturn(odontologos);

        // Act
        ResponseEntity<List<Odontologo>> response = odontologoController.listarTodos();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(odontologos, response.getBody());
    }

    @Test
    void actualizar_DeberiaActualizarOdontologo() {
        // Arrange
        Odontologo odontologo = new Odontologo();
        odontologo.setIdOdontologo(1L);
        when(odontologoService.buscarPorIdOdontologo(odontologo.getIdOdontologo())).thenReturn(odontologo);

        // Act
        ResponseEntity<String> response = odontologoController.actualizar(odontologo);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Se actualizó el odontologo con id " + odontologo.getIdOdontologo(), response.getBody());
        verify(odontologoService, times(1)).actualizarOdontologo(odontologo);
    }

    @Test
    void actualizar_DeberiaLanzarExcepcionCuandoOdontologoNoExiste() {
        // Arrange
        Odontologo odontologo = new Odontologo();
        odontologo.setIdOdontologo(1L);
        when(odontologoService.buscarPorIdOdontologo(odontologo.getIdOdontologo()))
                .thenThrow(new ResourceNotFoundException("Odontologo not found"));

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> odontologoController.actualizar(odontologo));
    }

    @Test
    void findByMatricula_DeberiaRetornarOdontologoExistente() throws Exception {
        // Arrange
        String matricula = "1234522444";
        Odontologo odontologo = new Odontologo();
        when(odontologoService.findByMatriculaOdontologo(matricula)).thenReturn(Optional.of(odontologo));

        // Act
        ResponseEntity<Odontologo> response = odontologoController.findByMatricula(matricula);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(odontologo, response.getBody());
        verify(odontologoService, times(1)).findByMatriculaOdontologo(matricula);
    }

    @Test
    void findByMatricula_DeberiaLanzarExcepcionCuandoOdontologoNoExiste() {
        // Arrange
        String matriculaNoExistente = "98765";

        // Set up the mocked service to throw a ResourceNotFoundException
        when(odontologoService.findByMatriculaOdontologo(matriculaNoExistente))
                .thenThrow(new ResourceNotFoundException("Odontólogo no encontrado con matrícula: " + matriculaNoExistente));

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> odontologoController.findByMatricula(matriculaNoExistente));

        // Verify that the findByMatriculaOdontologo method was called with the correct argument
        Mockito.verify(odontologoService).findByMatriculaOdontologo(matriculaNoExistente);
    }
}
