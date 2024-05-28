package com.escuela.sistema.sistema_control.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AulaDTO {
    private Long aula_id;
    private String aula_name;
    private Long aula_grado;
}
