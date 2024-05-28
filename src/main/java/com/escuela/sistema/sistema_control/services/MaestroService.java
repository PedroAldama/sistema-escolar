package com.escuela.sistema.sistema_control.services;


import com.escuela.sistema.sistema_control.entities.Maestro;

import java.util.List;
import java.util.Optional;

public interface MaestroService  {
    List<Maestro> findAll();
    Optional<Maestro> findByName(String name);
    Optional<Maestro> findByNoControl(Long control);
}
