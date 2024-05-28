package com.escuela.sistema.sistema_control.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="asistencias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsistencia;
    private Date fechaAsistencia;
    private Time horaAsistencia;
    private String asistencia;

    @ManyToOne
    @JsonIgnoreProperties({"asistencias","alumnos","id","clases","hibernateLazyInitializer", "handler"})
    private Aula aula;

    @ManyToOne
    @JsonIgnoreProperties({"asistencias","aulas","id","hibernateLazyInitializer", "handler"})
    private Clase clase;

    @ManyToOne
    @JsonIgnoreProperties({"asistencias","hibernateLazyInitializer", "handler"})
    @JoinColumn(referencedColumnName = "matricula")
    private Alumno alumno;


    @JsonCreator
    public Asistencia( @JsonProperty("asistencia") String asistencia,
                      @JsonProperty("aula") Aula aula, @JsonProperty("clase") Clase clase, @JsonProperty("alumno") Alumno alumno) {

        this.asistencia = asistencia;
        this.aula = aula;
        this.alumno = alumno;
        this.clase = clase;
    }
}
