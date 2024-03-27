package com.juandavidvanegasroldan.juandavidvanegasroldan.service;

import com.juandavidvanegasroldan.juandavidvanegasroldan.dto.request.TurnoRequestDTO;
import com.juandavidvanegasroldan.juandavidvanegasroldan.dto.response.TurnoResponseDTO;
import com.juandavidvanegasroldan.juandavidvanegasroldan.entity.Turno;

import java.util.List;

public interface ITurnoService {
    TurnoResponseDTO guardarTurno(TurnoRequestDTO turno);
    List<Turno> listarTodosTurnos();

    Turno buscarPorIdTurno(Integer id);

    void eliminarTurno(Long id);

    void actualizarTurno(Turno turno);


}
