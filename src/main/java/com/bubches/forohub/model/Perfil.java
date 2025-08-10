package com.bubches.forohub.model;

import jakarta.persistence.*;

@Entity
@Table(name = "perfiles")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    public Perfil() {}

    // Getters y Setters
}
