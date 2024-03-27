package com.juandavidvanegasroldan.juandavidvanegasroldan.repository;

import com.juandavidvanegasroldan.juandavidvanegasroldan.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {
    Optional<Odontologo> findByMatriculaOdontologo(String matricula);
}
