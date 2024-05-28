package com.escuela.sistema.sistema_control.services;


import com.escuela.sistema.sistema_control.entities.Alumno;
import com.escuela.sistema.sistema_control.entities.Asistencia;
import com.escuela.sistema.sistema_control.entities.Aula;

import java.util.List;
import java.util.Optional;

public interface AlumnoService{

    List<Alumno> findAll();

    List<Alumno> findByAula(Aula aula_id);

    //List<Asistencia> findByAsistencia();

    Optional<Alumno> findByName(String nombre);

    Optional<Alumno> findByMatricula(String matricula);

    Alumno save(Alumno alumno);

    Optional<Alumno> update(String matricula,Alumno alumno);

    //List<Asistencia> findByAsistenciaAlumno(String asistencia, String matricula);


}
