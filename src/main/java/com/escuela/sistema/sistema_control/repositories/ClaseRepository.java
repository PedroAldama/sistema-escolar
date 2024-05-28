package com.escuela.sistema.sistema_control.repositories;

import com.escuela.sistema.sistema_control.entities.Aula;
import com.escuela.sistema.sistema_control.entities.Clase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClaseRepository extends JpaRepository<Clase, Long> {

    List<Clase> findByMaestro_NoControl(Long noControl);

    List<Clase> findByAulas(Aula aula);

    Optional<Clase> findByName(String name);
}
