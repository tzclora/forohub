package com.bubches.forohub.config;

import com.bubches.forohub.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UsuarioService usuarioService;

    @Override
    public void run(String... args) throws Exception {
        String email = "admin@forohub.com";
        String password = "admin123";
        String nombre = "Administrador";

        if (!usuarioService.usuarioExiste(email)) {
            usuarioService.crearUsuario(email, password, nombre);
            System.out.println("Usuario admin creado con correo: " + email + " y password: " + password);
        } else {
            System.out.println("Usuario admin ya existe.");
        }
    }
}
