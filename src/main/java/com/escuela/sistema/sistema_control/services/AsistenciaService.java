package com.escuela.sistema.sistema_control.services;


import com.escuela.sistema.sistema_control.dto.AsistenciaDTO;
import com.escuela.sistema.sistema_control.entities.Alumno;
import com.escuela.sistema.sistema_control.entities.Asistencia;
import com.escuela.sistema.sistema_control.entities.Aula;

import java.util.List;

public interface AsistenciaService  {

    Asistencia save(AsistenciaDTO asistencia);

    List<Asistencia> findAll();

    List<Asistencia> findByAsistenciaAlumno(String matricula, String asistencia);

    List<Asistencia> findAllByAlumno_Matricula(String matricula);

    List<Asistencia> findAllByAula(Aula aula);

    List<Asistencia> findAllByClase_Name(String name);

}
