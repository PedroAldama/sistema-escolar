package com.escuela.sistema.sistema_control.repositories;


import com.escuela.sistema.sistema_control.entities.Asistencia;
import com.escuela.sistema.sistema_control.entities.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface AsistenciaRepository extends JpaRepository<Asistencia,Long> {

    List<Asistencia> findAllByAlumno_Matricula(String matricula);

    List<Asistencia> findAllByAula(Aula aula);

    List<Asistencia> findAllByClase_Name(String name);

}
