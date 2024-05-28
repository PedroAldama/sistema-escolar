package com.escuela.sistema.sistema_control.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clases")
@Getter
@Setter
@JsonIgnoreProperties({"asistencias"})
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @ManyToMany(mappedBy = "clases")
    @JsonIgnoreProperties({"clases","asistencias","hibernateLazyInitializer", "handler"})
    private Set<Aula> aulas;

    @ManyToOne
    @JoinColumn(name="maestro_id")
    @JsonIgnoreProperties({"clases","noControl","hibernateLazyInitializer", "handler"})
    private Maestro maestro;

    @OneToMany(mappedBy = "clase", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"clase","alumno","hibernateLazyInitializer", "handler"})
    private Set<Asistencia> asistencias;

    public Clase() {
        this.aulas = new HashSet<>();
        this.asistencias = new HashSet<>();
    }

    public Clase(Long id, String nombre) {
        this();
        this.id = id;
        this.name = nombre;
    }


}
