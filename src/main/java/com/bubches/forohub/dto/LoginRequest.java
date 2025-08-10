package com.bubches.forohub.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String correoElectronico;
    private String contrasena;
}
