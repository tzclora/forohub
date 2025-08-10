package com.bubches.forohub.repository;

import com.bubches.forohub.model.Tema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TemaRepository extends JpaRepository<Tema, Long> {
    Optional<Tema> findByTituloAndMensaje(String titulo, String mensaje);

    Page<Tema> findAllByOrderByFechaCreacionAsc(Pageable pageable);

    // Listar con filtro por nombre de curso y año del tópico (fechaCreacion)
    Page<Tema> findByCursoNombreAndFechaCreacionBetween(
            String nombreCurso,
            LocalDateTime inicio,
            LocalDateTime fin,
            Pageable pageable
    );
}
