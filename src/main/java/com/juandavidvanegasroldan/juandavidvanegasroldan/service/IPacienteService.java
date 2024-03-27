package com.juandavidvanegasroldan.juandavidvanegasroldan.service;

import com.juandavidvanegasroldan.juandavidvanegasroldan.entity.Odontologo;
import com.juandavidvanegasroldan.juandavidvanegasroldan.entity.Paciente;

import java.util.List;

public interface IPacienteService {

    Paciente guardarPaciente(Paciente paciente);
    List<Paciente> listarTodosPacientes();

    Paciente buscarPorIdPaciente(Long id);
    void eliminarPaciente(Long id);
    void actualizarPaciente(Paciente paciente);
}
