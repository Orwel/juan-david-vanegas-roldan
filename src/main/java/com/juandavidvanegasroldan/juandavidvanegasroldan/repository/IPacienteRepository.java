package com.juandavidvanegasroldan.juandavidvanegasroldan.repository;

import com.juandavidvanegasroldan.juandavidvanegasroldan.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
}
