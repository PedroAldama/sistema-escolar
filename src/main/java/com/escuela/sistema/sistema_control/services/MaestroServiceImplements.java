package com.escuela.sistema.sistema_control.services;

import com.escuela.sistema.sistema_control.entities.Maestro;
import com.escuela.sistema.sistema_control.repositories.MaestroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaestroServiceImplements implements MaestroService{

    @Autowired
    private MaestroRepository repository;

    @Override
    public List<Maestro> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Maestro> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Optional<Maestro> findByNoControl(Long control) {
        return repository.findByNoControl(control);
    }
}
