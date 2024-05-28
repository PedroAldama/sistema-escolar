package com.escuela.sistema.sistema_control.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"username","message","jwt","status"})
public record AuthResponse(String username,
                           String message,
                           String jwt,
                           boolean status){

}
