package com.escuela.sistema.sistema_control.services;

import com.escuela.sistema.sistema_control.entities.Alumno;
import com.escuela.sistema.sistema_control.entities.Asistencia;
import com.escuela.sistema.sistema_control.entities.Aula;
import com.escuela.sistema.sistema_control.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AlumnoServiceImplements implements AlumnoService{

    @Autowired
    private AlumnoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> findAll() {
        return (List<Alumno>) repository.findAll();
    }

    @Override
    public List<Alumno> findByAula(Aula aula_id) {
        return (List<Alumno>) repository.findByAula(aula_id);
    }

//    @Override
//    public List<Asistencia> findByAsistencia() {
//
//        List<Asistencia> listaAsistencia = new ArrayList<>();
//        List<Alumno> list = (List<Alumno>) repository.findAll();
//        list = list.stream().filter(alumno -> {
//            return !alumno.getAsistencias().isEmpty();
//        }).toList();
//        for(Alumno alumno :list){
//            listaAsistencia.addAll(alumno.getAsistencias().stream()
//                    .filter(asistencia -> asistencia.getAsistencia().equals("SI"))
//                    .toList());
//        }
//        return listaAsistencia;
//    }

//    @Override
//    public List<Asistencia> findByAsistenciaAlumno(String asistencia, String matricula) {
//        List<Asistencia> listaAsistencia = new ArrayList<>();
//        Optional<Alumno> optionalAlumno = repository.findByMatricula(matricula);
//        if(optionalAlumno.isPresent()){
//            Alumno alumno = optionalAlumno.get();
//            listaAsistencia = alumno.getAsistencias()
//                    .stream()
//                    .filter(asistencia1 -> asistencia1.getAsistencia().equals(asistencia))
//                    .toList();
//        }
//        return listaAsistencia;
//    }



    @Override
    @Transactional(readOnly = true)
    public Optional<Alumno> findByName(String nombre) {
        return repository.findByName(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Alumno> findByMatricula(String matricula) {
        return repository.findByMatricula(matricula);
    }

    @Override
    @Transactional
    public Alumno save(Alumno alumno) {
        return repository.save(alumno);
    }

    @Override
    @Transactional
    public Optional<Alumno> update(String matricula,Alumno alumno) {
        Optional<Alumno> optionalAlumno = repository.findByMatricula(matricula);
        if(optionalAlumno.isPresent()){
            Alumno alumnoDB = optionalAlumno.get();
            alumnoDB.setName(alumno.getName());
            alumnoDB.setMatricula(alumno.getMatricula());
            return Optional.of(save(alumnoDB));
        }
        return optionalAlumno;
    }


}
