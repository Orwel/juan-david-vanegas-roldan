package com.juandavidvanegasroldan.juandavidvanegasroldan.service.implementation;

import com.juandavidvanegasroldan.juandavidvanegasroldan.dto.request.TurnoRequestDTO;
import com.juandavidvanegasroldan.juandavidvanegasroldan.dto.response.TurnoResponseDTO;
import com.juandavidvanegasroldan.juandavidvanegasroldan.entity.Odontologo;
import com.juandavidvanegasroldan.juandavidvanegasroldan.entity.Paciente;
import com.juandavidvanegasroldan.juandavidvanegasroldan.entity.Turno;
import com.juandavidvanegasroldan.juandavidvanegasroldan.repository.ITurnoRepository;
import com.juandavidvanegasroldan.juandavidvanegasroldan.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    private ITurnoRepository turnoRepository;
    @Autowired
    public TurnoService(ITurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public TurnoResponseDTO guardarTurno(TurnoRequestDTO turnoRequestDTO) {

        Turno turnoEntity = new Turno(); //Turno(null, null, null, null)

        //instanciamos Paciente
        Paciente paciente = new Paciente();
        paciente.setIdPaciente(turnoRequestDTO.getPaciente_id());

        //instanciamos Odontologo
        Odontologo odontologo = new Odontologo();
        odontologo.setIdOdontologo(turnoRequestDTO.getOdontologo_id());

        //seteamos Paciente y Odontologo a la entidad Turno
        turnoEntity.setOdontologo(odontologo);
        turnoEntity.setPaciente(paciente);
        turnoEntity.setPaciente(paciente);

        //convertir el String del turnoRequestDTO a LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //creamos el LocalDate que vamos a tener que persistir en la BD
        LocalDate date = LocalDate.parse(turnoRequestDTO.getFecha(), formatter);

        //seteamos al turno la fecha
        turnoEntity.setFechaYHoraTurno(date);

        //persistir el turno en la BD
        turnoRepository.save(turnoEntity);
        //acá ya tenemos la entidad con id

        //ESTE ES EL CAMINO DE VUELTA HACIA EL CONTROLADOR
        //PORQUE YA SE PERSISTIÓ LA ENTIDAD
        //mapear la entidad persistida en un dto
        TurnoResponseDTO turnoResponseDTO = new TurnoResponseDTO(); //TurnoDto(null, null, null, null)
        turnoResponseDTO.setId(turnoEntity.getIdTurno());
        turnoResponseDTO.setOdontologo_id(turnoEntity.getOdontologo().getIdOdontologo());
        turnoResponseDTO.setPaciente_id(turnoEntity.getPaciente().getIdPaciente());
        turnoResponseDTO.setFecha(turnoEntity.getFechaYHoraTurno().toString());

        return turnoResponseDTO;
    }

    @Override
    public List<Turno> listarTodosTurnos() {
        return null;
    }

    @Override
    public Turno buscarPorIdTurno(Integer id) {
        return null;
    }

    @Override
    public void eliminarTurno(Long id) {

    }

    @Override
    public void actualizarTurno(Turno turno) {

    }
}
