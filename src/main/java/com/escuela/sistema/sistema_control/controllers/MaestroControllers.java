package com.escuela.sistema.sistema_control.controllers;

import com.escuela.sistema.sistema_control.entities.Maestro;
import com.escuela.sistema.sistema_control.services.MaestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Controller
@RequestMapping("/maestros")
public class MaestroControllers {

    @Autowired
    private MaestroService service;

    @GetMapping
    public List<Maestro> getAll(){
        return service.findAll();
    }

    @GetMapping("/nombre/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name){
        Optional<Maestro> maestroOptional = service.findByName(name);
        if(maestroOptional.isPresent()){
            return ResponseEntity.ok(maestroOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/control/{control}")
    public ResponseEntity<?> getByControl(@PathVariable Long control){
        Optional<Maestro> maestroOptional = service.findByNoControl(control);

        if(maestroOptional.isPresent()){
            return ResponseEntity.ok(maestroOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
