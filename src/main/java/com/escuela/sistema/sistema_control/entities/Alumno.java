package com.escuela.sistema.sistema_control.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "alumnos")
@Getter
@Setter
@JsonIgnoreProperties({"id","aula"})
public class Alumno extends Persona{

    @NotNull
    @Column(unique = true)
    private String matricula;

    @ManyToOne
    @JoinColumn(name = "aula")
    @JsonIgnoreProperties({"alumnos","clases","asistencias","hibernateLazyInitializer", "handler"})
    private Aula aula;


    @OneToMany(mappedBy = "alumno", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"alumno","hibernateLazyInitializer", "handler"})
    private Set<Asistencia> asistencias;

    public Alumno() {
        super();
        this.asistencias = new HashSet<>();
    }

    public Alumno(Long id, String name, String middlename, String lastname, String secondLastname, String email, String matricula, Aula aula, Set<Asistencia> asistencia) {
        super(id, name, middlename, lastname, secondLastname, email);
        this.asistencias = new HashSet<>(asistencia);
        this.matricula = matricula;
        this.aula = aula;
    }
}
