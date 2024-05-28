package com.escuela.sistema.sistema_control.controllers;

import com.escuela.sistema.sistema_control.dto.AsistenciaDTO;
import com.escuela.sistema.sistema_control.entities.*;
import com.escuela.sistema.sistema_control.services.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@PreAuthorize("denyAll()")
@RequestMapping("/asistencias")
public class AsistenciaControllers {

    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping("/lista")
    @PreAuthorize("hasAuthority('READ')")
    public List<AsistenciaDTO> listarAsistencias(){
        List<Asistencia> listaDAO = asistenciaService.findAll();
        return setListDTO(listaDAO);
    }

    @GetMapping("/{matricula}/{asistencia}")
    public List<AsistenciaDTO> listarPorAlumno(@PathVariable String matricula, @PathVariable String asistencia){
        List<Asistencia> lista=  asistenciaService.findByAsistenciaAlumno(matricula, asistencia);
        return setListDTO(lista);
    }

    @GetMapping("/alumno/{matricula}")
    @PreAuthorize("hasAnyAuthority('READ')")
    public List<AsistenciaDTO> listarPorMatricula(@PathVariable String matricula) {
        List<Asistencia> listaDAO = asistenciaService.findAllByAlumno_Matricula(matricula);
       return setListDTO(listaDAO);
    }

    @GetMapping("/aula/{aula}")
    public List<AsistenciaDTO> listarPorAula(@PathVariable Aula aula){
        List<Asistencia> lista = asistenciaService.findAllByAula(aula);
        return setListDTO(lista);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('CREATE','ADMIN','REFACTOR')")
    public ResponseEntity<?> setAsistencia(@RequestBody AsistenciaDTO asistencia){
        return ResponseEntity.status(HttpStatus.CREATED).body(asistenciaService.save(asistencia));
    }


    @GetMapping("/clase/{nombre}")
    @PreAuthorize("hasAuthority('REFACTOR')")
    public List<AsistenciaDTO> listarPorClase(@PathVariable String nombre){
         List<Asistencia> lista = asistenciaService.findAllByClase_Name(nombre);
        return setListDTO(lista);
    }

    private AsistenciaDTO setDTOData(Asistencia asistencia, Alumno alumno, Maestro maestro, Clase clase, Aula aula){
        AsistenciaDTO asistenciaDTO = new AsistenciaDTO();
        asistenciaDTO.setAsistencia(asistencia.getAsistencia());
        asistenciaDTO.setFechaAsistencia(asistencia.getFechaAsistencia());
        asistenciaDTO.setHoraAsistencia((asistencia.getHoraAsistencia()));
        asistenciaDTO.setNombre_alumno(alumno.getName() + " " + alumno.getLastname());
        asistenciaDTO.setMatricula_alumno(alumno.getMatricula());
        asistenciaDTO.setAula(aula.getGrado() + " " + aula.getName());
        asistenciaDTO.setClase(clase.getName());
        asistenciaDTO.setMaestro(maestro.getName() + " " + maestro.getLastname());
        return asistenciaDTO;
    }

    private List<AsistenciaDTO> setListDTO(List<Asistencia> asistencias){
        List<AsistenciaDTO> listaDTO = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            listaDTO.add(setDTOData(asistencia,
                    asistencia.getAlumno(),
                    asistencia.getClase().getMaestro(),
                    asistencia.getClase(),
                    asistencia.getAula()));
        }
        return listaDTO;
    }
}
