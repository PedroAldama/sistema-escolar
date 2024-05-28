package com.escuela.sistema.sistema_control.dto;

import com.escuela.sistema.sistema_control.entities.Aula;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoDTO {

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String matricula;

    private AulaDTO aula;


    public void setAulaDtoMetod(Long id, String name, Long grado){
        this.aula = new AulaDTO();
        this.aula.setAula_id(id);
        this.aula.setAula_name(name);
        this.aula.setAula_grado(grado);
    }
}
