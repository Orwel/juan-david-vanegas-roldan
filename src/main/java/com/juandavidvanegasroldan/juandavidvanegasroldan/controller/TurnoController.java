package com.juandavidvanegasroldan.juandavidvanegasroldan.controller;
import java.util.logging.Logger;
import com.juandavidvanegasroldan.juandavidvanegasroldan.dto.request.TurnoRequestDTO;
import com.juandavidvanegasroldan.juandavidvanegasroldan.dto.response.TurnoResponseDTO;
import com.juandavidvanegasroldan.juandavidvanegasroldan.service.IOdontologoService;
import com.juandavidvanegasroldan.juandavidvanegasroldan.service.IPacienteService;
import com.juandavidvanegasroldan.juandavidvanegasroldan.service.ITurnoService;
import com.juandavidvanegasroldan.juandavidvanegasroldan.service.implementation.OdontologoService;
import com.juandavidvanegasroldan.juandavidvanegasroldan.service.implementation.PacienteService;
import com.juandavidvanegasroldan.juandavidvanegasroldan.service.implementation.TurnoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private static final Logger LOGGER = Logger.getLogger(TurnoController.class.getName());


    private ITurnoService turnoService;
    private IOdontologoService odontologoService;
    private IPacienteService pacienteService;

    @Autowired
    public TurnoController(TurnoService turnoService, OdontologoService odontologoService, PacienteService pacienteService) {
        this.turnoService = turnoService;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }


    //endpoint para guardar un turnoRequestDTO
    @PostMapping
    public ResponseEntity<TurnoResponseDTO> guardar(@RequestBody TurnoRequestDTO turnoRequestDTO) {
        ResponseEntity<TurnoResponseDTO> response;

        LOGGER.info("esto trae el turnoRequestDTO: " + turnoRequestDTO);
//        vamos a chequear que exista el odontologo y la paciente
        if (odontologoService.buscarPorIdOdontologo(turnoRequestDTO.getOdontologo_id()) != null &&
                pacienteService.buscarPorIdPaciente(turnoRequestDTO.getPaciente_id()) != null) {



        //setear una respuesta en 200 y vamos a hacer que devuelva el turnoRequestDTO
            response = ResponseEntity.ok(turnoService.guardarTurno(turnoRequestDTO));

        } else {
            //si no existe el odontologo o el paciente
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }
        return response;
    }


}

