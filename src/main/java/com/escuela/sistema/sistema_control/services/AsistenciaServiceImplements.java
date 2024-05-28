package com.escuela.sistema.sistema_control.services;

import com.escuela.sistema.sistema_control.dto.AsistenciaDTO;
import com.escuela.sistema.sistema_control.entities.Alumno;
import com.escuela.sistema.sistema_control.entities.Asistencia;
import com.escuela.sistema.sistema_control.entities.Aula;
import com.escuela.sistema.sistema_control.entities.Clase;
import com.escuela.sistema.sistema_control.repositories.AlumnoRepository;
import com.escuela.sistema.sistema_control.repositories.AsistenciaRepository;
import com.escuela.sistema.sistema_control.repositories.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServiceImplements implements AsistenciaService{

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private ClaseRepository claseRepository;

    @Override
    public Asistencia save(AsistenciaDTO asistencia) {
        Asistencia registrarAsistencia = new Asistencia();
        registrarAsistencia.setAsistencia(asistencia.getAsistencia());

        Optional<Alumno> alumno = alumnoRepository.findByMatricula(asistencia.getMatricula_alumno());
        Optional<Clase> clase = claseRepository.findByName(asistencia.getClase());
        if(alumno.isPresent()){
            registrarAsistencia.setAlumno(alumno.get());
            registrarAsistencia.setAula(alumno.get().getAula());
        }
        clase.ifPresent(registrarAsistencia::setClase);

        registrarAsistencia.setFechaAsistencia(new Date());
        registrarAsistencia.setHoraAsistencia(Time.valueOf(LocalTime.now()));
        return asistenciaRepository.save(registrarAsistencia);
    }


    @Override
    public List<Asistencia> findAll() {
        return asistenciaRepository.findAll();
    }

    @Override
    public List<Asistencia> findByAsistenciaAlumno(String matricula, String asistencia) {
        Optional<Alumno> optionalAlumno = alumnoRepository.findByMatricula(matricula);
        List<Asistencia> lista = new ArrayList<>();

        if (optionalAlumno.isPresent()){
            Alumno alumno = optionalAlumno.get();
            lista = alumno.getAsistencias()
                    .stream()
                    .filter(asistencia1 -> asistencia1.getAsistencia().equals(asistencia))
                    .toList();
        }

        return lista;
    }

    @Override
    public List<Asistencia> findAllByAlumno_Matricula(String matricula) {
        return asistenciaRepository.findAllByAlumno_Matricula(matricula);
    }

    @Override
    public List<Asistencia> findAllByAula(Aula aula) {
        return  asistenciaRepository.findAllByAula(aula);
    }

    @Override
    public List<Asistencia> findAllByClase_Name(String name) {
        return asistenciaRepository.findAllByClase_Name(name);
    }


}
