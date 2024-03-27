package com.juandavidvanegasroldan.juandavidvanegasroldan.service.implementation;

import com.juandavidvanegasroldan.juandavidvanegasroldan.entity.Odontologo;
import com.juandavidvanegasroldan.juandavidvanegasroldan.exception.ResourceNotFoundException;
import com.juandavidvanegasroldan.juandavidvanegasroldan.repository.IOdontologoRepository;
import com.juandavidvanegasroldan.juandavidvanegasroldan.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {
    private IOdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoService(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo) {
        // Validación de entrada
        if (odontologo == null) {
            throw new IllegalArgumentException("El odontólogo no puede ser nulo");
        }
        return odontologoRepository.save(odontologo);
    }

    @Override
    public List<Odontologo> listarTodosOdontologos() {
        return odontologoRepository.findAll();
    }

    @Override
    public Odontologo buscarPorIdOdontologo(Long id) {
        Optional<Odontologo> odontologoOptional = odontologoRepository.findById(id);
        // Validación de resultado
        return odontologoOptional.orElseThrow(() -> new ResourceNotFoundException("Odontólogo no encontrado con el ID: " + id));
    }

    @Override
    public void actualizarOdontologo(Odontologo odontologo) {
        // Validación de entrada
        if (odontologo == null || odontologo.getIdOdontologo() == null) {
            throw new IllegalArgumentException("El odontólogo o su ID no pueden ser nulos");
        }
        odontologoRepository.save(odontologo);
    }

    @Override
    public Optional<Odontologo> findByMatriculaOdontologo(String matricula) {
        // Validación de entrada
        if (matricula == null || matricula.isEmpty()) {
            throw new IllegalArgumentException("La matrícula no puede ser nula o vacía");
        }
        return odontologoRepository.findByMatriculaOdontologo(matricula);
    }
}
