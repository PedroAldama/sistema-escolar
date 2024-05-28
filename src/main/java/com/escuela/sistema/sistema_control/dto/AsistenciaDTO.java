package com.escuela.sistema.sistema_control.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AsistenciaDTO {

    private String asistencia;
    private String matricula_alumno;
    private String nombre_alumno;
    private Date fechaAsistencia;
    private Date horaAsistencia;
    private String aula;
    private String clase;
    private String maestro;
}
