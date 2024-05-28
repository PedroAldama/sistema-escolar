package com.escuela.sistema.sistema_control.repositories;

import com.escuela.sistema.sistema_control.entities.Alumno;
import com.escuela.sistema.sistema_control.entities.Asistencia;
import com.escuela.sistema.sistema_control.entities.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AlumnoRepository extends CrudRepository<Alumno,Long> {


    List<Alumno> findByAula(Aula aula);

    Optional<Alumno> findByName(String name);

    Optional<Alumno> findByMatricula(String matricula);

}
