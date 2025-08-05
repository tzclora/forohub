package com.bubches.forohub.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "temas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String mensaje;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario autor;

    @OneToMany(mappedBy = "tema", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Respuesta> respuestas;

    @Enumerated(EnumType.STRING)
    private  Status status = Status.NO_RESPONDIDO;

    public enum Status{
        NO_RESPONDIDO,
        NO_SOLUCIONADO,
        SOLUCIONADO,
        CERRADO
    }
}
