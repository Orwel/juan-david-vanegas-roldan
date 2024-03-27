package com.juandavidvanegasroldan.juandavidvanegasroldan.controller;

import com.juandavidvanegasroldan.juandavidvanegasroldan.entity.Odontologo;
import com.juandavidvanegasroldan.juandavidvanegasroldan.exception.ResourceNotFoundException;
import com.juandavidvanegasroldan.juandavidvanegasroldan.service.IOdontologoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private IOdontologoService odontologoService;


    @Autowired
    public OdontologoController (IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }
    //busca por id
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Long id) {
        try {
            Odontologo odontologo = odontologoService.buscarPorIdOdontologo(id);
            return ResponseEntity.ok(odontologo);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    //guarda un odontologo
    @PostMapping
    public ResponseEntity<Odontologo> guardar(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }


    //lista todos los odontologos
    @GetMapping
    public ResponseEntity<List<Odontologo>> listarTodos() {
        return ResponseEntity.ok(odontologoService.listarTodosOdontologos());
    }

    //actualizar un odontologo
    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody Odontologo odontologo) {
        ResponseEntity<String> response;
        Odontologo odontologoBuscado = odontologoService.buscarPorIdOdontologo(odontologo.getIdOdontologo());
        if (odontologoBuscado != null) {
            odontologoService.actualizarOdontologo(odontologo);
            response = ResponseEntity.ok("Se actualizó el odontologo con id " + odontologo.getIdOdontologo());
        } else {
            response = ResponseEntity.ok().body("No se puede actualizar el odontologo");
        }
        return response;
    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<Odontologo> findByMatricula(@PathVariable String matricula) {
        Optional<Odontologo> odontologoOptional = odontologoService.findByMatriculaOdontologo(matricula);
        if (odontologoOptional.isPresent()) {
            return ResponseEntity.ok(odontologoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    }





