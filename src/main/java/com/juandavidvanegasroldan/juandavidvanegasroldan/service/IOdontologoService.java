package com.juandavidvanegasroldan.juandavidvanegasroldan.service;

import com.juandavidvanegasroldan.juandavidvanegasroldan.entity.Odontologo;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface IOdontologoService {
    Odontologo guardarOdontologo(Odontologo odontologo);
    List<Odontologo> listarTodosOdontologos();
    Odontologo buscarPorIdOdontologo(Long id);
    void actualizarOdontologo(Odontologo odontologo);
    Optional<Odontologo> findByMatriculaOdontologo(String matricula);

}
