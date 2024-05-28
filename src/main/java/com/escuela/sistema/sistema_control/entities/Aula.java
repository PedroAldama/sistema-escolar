package com.escuela.sistema.sistema_control.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "aula")
@Getter
@Setter

public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long grado;


    @OneToMany(mappedBy = "aula",cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"aula","hibernateLazyInitializer", "handler"})
    private Set<Alumno> alumnos;


    @ManyToMany
    @JsonIgnoreProperties({"aulas","hibernateLazyInitializer", "handler"})
    @JoinTable(
            name = "aula_clase",
            joinColumns = @JoinColumn(name = "aula_id"),
            inverseJoinColumns = @JoinColumn(name= "clase_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"aula_id","clase_id"})}

    )
    private Set<Clase> clases;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "aula")
    @JsonIgnoreProperties({"aula","hibernateLazyInitializer", "handler"})
    private List<Asistencia> asistencias;

    public Aula() {
        this.alumnos = new HashSet<>();
        this.clases = new HashSet<>();
    }
    public Aula(String name, Long grado) {
        this();
        this.name = name;
        this.grado = grado;
    }
}
