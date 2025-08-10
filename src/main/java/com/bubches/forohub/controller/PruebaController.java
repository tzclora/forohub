package com.bubches.forohub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaController {

    @GetMapping("/api/saludo")
    public String saludo() {
        return "¡Hola usuario autenticado! Acceso concedido.";
    }
}
