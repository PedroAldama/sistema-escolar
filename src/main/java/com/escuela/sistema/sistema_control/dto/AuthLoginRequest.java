package com.escuela.sistema.sistema_control.dto;

import jakarta.validation.constraints.NotNull;

public record AuthLoginRequest(@NotNull String username,@NotNull String password) {
}
