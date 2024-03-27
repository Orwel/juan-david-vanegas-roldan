package com.juandavidvanegasroldan.juandavidvanegasroldan.service.implementation;

import com.juandavidvanegasroldan.juandavidvanegasroldan.entity.Paciente;
import com.juandavidvanegasroldan.juandavidvanegasroldan.repository.IPacienteRepository;
import com.juandavidvanegasroldan.juandavidvanegasroldan.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService {

    private IPacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public List<Paciente> listarTodosPacientes() {
        return null;
    }

    @Override
    public Paciente buscarPorIdPaciente(Long id) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        if (pacienteOptional.isPresent()) {
            return pacienteOptional.get();
        }
        return null;
    }
    @Override
    public void eliminarPaciente(Long id) {

    }
    @Override
    public void actualizarPaciente(Paciente paciente) {

    }
}
