package com.escuela.sistema.sistema_control.dto;

import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public record AuthCreateRoleRequest(@Size(max=8, message = "User cannot have more than 3 roles")
                                    List<String> roleListName) {
}
