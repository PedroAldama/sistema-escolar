package com.escuela.sistema.sistema_control.controllers;

import com.escuela.sistema.sistema_control.dto.AlumnoDTO;
import com.escuela.sistema.sistema_control.entities.Alumno;
import com.escuela.sistema.sistema_control.entities.Aula;
import com.escuela.sistema.sistema_control.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RestController
@RequestMapping("/alumnos")
public class AlumnoControllers {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<AlumnoDTO> listar(){
        List<Alumno> listaDAO = alumnoService.findAll();
        List<AlumnoDTO> listaDTO = new ArrayList<>();
        for(Alumno alumno :listaDAO){
            listaDTO.add(setDTOData(alumno));
        }
        return listaDTO;
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        Optional<Alumno> optionalAlumno = alumnoService.findByName(name);
        if(optionalAlumno.isPresent()){
            Alumno alumno = optionalAlumno.get();
            return ResponseEntity.ok(setDTOData(alumno));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping({"/aula/{aula}"})
    public List<Alumno> findByAula(@PathVariable Aula aula){
        return  alumnoService.findByAula(aula);
    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<?> findByMatricula(@PathVariable String matricula){
        Optional<Alumno> optionalAlumno = alumnoService.findByMatricula(matricula);
        if(optionalAlumno.isPresent()){
            return ResponseEntity.ok(setDTOData(optionalAlumno.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<?> update(@PathVariable String matricula, @RequestBody Alumno alumno){
        Optional<Alumno> optionalAlumno = alumnoService.update(matricula, alumno);
        if(optionalAlumno.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(optionalAlumno.get());
        }
        return ResponseEntity.notFound().build();
    }

    //@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public ResponseEntity<?> createAlumno(@RequestBody Alumno alumno){
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumno));
    }


    private AlumnoDTO setDTOData(Alumno alumno) {
        Aula aula = alumno.getAula();
        AlumnoDTO alumnoDTO = new AlumnoDTO();

        alumnoDTO.setId(alumno.getId());
        alumnoDTO.setName(alumno.getName());
        alumnoDTO.setLastname(alumno.getLastname());
        alumnoDTO.setMatricula(alumno.getMatricula());
        alumnoDTO.setEmail(alumno.getEmail());
        alumnoDTO.setAulaDtoMetod(aula.getId(),aula.getName(),aula.getGrado());

        return alumnoDTO;
    }
}

