package com.escuela.sistema.sistema_control.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"id"})
public class Maestro extends Persona {

    @NotNull
    private Long noControl;

    @OneToMany(mappedBy = "maestro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"maestro","hibernateLazyInitializer", "handler"})
    private Set<Clase> clases;

    public Maestro() {
        super();
        this.clases = new HashSet<>();
    }

    public Maestro(Long id,
                   String name,
                   String middlename,
                   String lastname,
                   String secondLastname,
                   String email,
                   Long noControl) {
        super(id, name, middlename, lastname, secondLastname, email);
        this.clases = new HashSet<>();
        this.noControl = noControl;
    }
}
