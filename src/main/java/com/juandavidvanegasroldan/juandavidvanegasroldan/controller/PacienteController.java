package com.juandavidvanegasroldan.juandavidvanegasroldan.controller;

import com.juandavidvanegasroldan.juandavidvanegasroldan.entity.Paciente;
import com.juandavidvanegasroldan.juandavidvanegasroldan.service.IPacienteService;
import com.juandavidvanegasroldan.juandavidvanegasroldan.service.implementation.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private IPacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public Paciente guardar(@RequestBody Paciente paciente) {
        return pacienteService.guardarPaciente(paciente);
    }


}

