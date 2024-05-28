package com.escuela.sistema.sistema_control.services;


import com.escuela.sistema.sistema_control.entities.Aula;
import com.escuela.sistema.sistema_control.entities.Clase;

import java.util.List;
import java.util.Optional;

public interface ClaseService  {

    List<Clase> findAll();

    Optional<Clase> findById(Long id);

    Optional<Clase> findByName(String name);

    List<Clase> findByMaestro_NoControl(Long noControl);

    List<Clase> findByAulas(Aula aula);
}
