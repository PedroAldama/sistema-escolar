package com.escuela.sistema.sistema_control.services;

import com.escuela.sistema.sistema_control.entities.Aula;
import com.escuela.sistema.sistema_control.entities.Clase;
import com.escuela.sistema.sistema_control.repositories.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseServiceImplementation implements ClaseService{

    @Autowired
    private ClaseRepository claseRepository;

    @Override
    public List<Clase> findAll() {
        return claseRepository.findAll();
    }

    @Override
    public Optional<Clase> findById(Long id) {
         return claseRepository.findById(id);

    }

    @Override
    public Optional<Clase> findByName(String name) {
        return claseRepository.findByName(name);
    }

    @Override
    public List<Clase> findByMaestro_NoControl(Long noControl) {
        return claseRepository.findByMaestro_NoControl(noControl);
    }

    @Override
    public List<Clase> findByAulas(Aula aula) {
        return claseRepository.findByAulas(aula);
    }
}
