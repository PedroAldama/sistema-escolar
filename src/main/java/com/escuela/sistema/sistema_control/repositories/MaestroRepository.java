package com.escuela.sistema.sistema_control.repositories;

import com.escuela.sistema.sistema_control.entities.Maestro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaestroRepository extends JpaRepository<Maestro,Long> {

    Optional<Maestro> findByNoControl(Long control);
    Optional<Maestro> findByName(String name);
}
