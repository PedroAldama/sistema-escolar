package com.escuela.sistema.sistema_control.controllers;

import com.escuela.sistema.sistema_control.entities.Aula;
import com.escuela.sistema.sistema_control.entities.Clase;
import com.escuela.sistema.sistema_control.services.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Controller
@RestController
@RequestMapping("/clases")
public class ClaseControllers {

    @Autowired
    private ClaseService claseService;

    @GetMapping
    public List<Clase> getAllClases() {
        return claseService.findAll();
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> getClaseByNombre(@PathVariable String nombre) {
        Optional<Clase> claseOptional =  claseService.findByName(nombre);
        return claseOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getClassById(@PathVariable Long id){
        Optional<Clase> claseOptional = claseService.findById(id);
        if(claseOptional.isPresent()){
            return ResponseEntity.ok(claseOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/aulas/{id}")
    public List<Clase> getClasByAula(@PathVariable Aula id){
        return claseService.findByAulas(id);
    }

    @GetMapping("/maestro/{control}")
    public List<Clase> getClasByMaestroControl(@PathVariable Long control){
        return claseService.findByMaestro_NoControl(control);
    }

}
