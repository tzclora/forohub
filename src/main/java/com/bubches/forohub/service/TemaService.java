package com.bubches.forohub.service;

import com.bubches.forohub.model.Curso;
import com.bubches.forohub.model.Tema;
import com.bubches.forohub.model.Usuario;
import com.bubches.forohub.repository.CursoRepository;
import com.bubches.forohub.repository.TemaRepository;
import com.bubches.forohub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TemaService {

    @Autowired
    private TemaRepository temaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Tema guardar(Tema tema) {
        // Validar duplicados (título y mensaje)
        temaRepository.findByTituloAndMensaje(tema.getTitulo(), tema.getMensaje())
                .ifPresent(t -> {
                    throw new RuntimeException("Ya existe un tópico con ese título y mensaje");
                });

        // Cargar autor
        Usuario autor = usuarioRepository.findById(tema.getAutor().getId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        // Cargar curso
        Curso curso = cursoRepository.findById(tema.getCurso().getId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        tema.setAutor(autor);
        tema.setCurso(curso);

        // Si es nuevo, establecer fecha de creación ahora
        if (tema.getFechaCreacion() == null) {
            tema.setFechaCreacion(LocalDateTime.now());
        }

        return temaRepository.save(tema);
    }

    public List<Tema> listarTodos() {
        return temaRepository.findAll();
    }

    public Optional<Tema> buscarPorId(Long id) {
        return temaRepository.findById(id);
    }

    public void eliminar(Long id) {
        temaRepository.deleteById(id);
    }

    public Tema actualizarTema(Long id, Tema datosActualizados) {
        return temaRepository.findById(id).map(temaExistente -> {
            // Validar duplicados: buscar por título y mensaje excluyendo el actual id
            temaRepository.findByTituloAndMensaje(datosActualizados.getTitulo(), datosActualizados.getMensaje())
                    .ifPresent(t -> {
                        if (!t.getId().equals(id)) {
                            throw new RuntimeException("Ya existe un tópico con ese título y mensaje");
                        }
                    });

            // Actualizar campos
            temaExistente.setTitulo(datosActualizados.getTitulo());
            temaExistente.setMensaje(datosActualizados.getMensaje());
            temaExistente.setStatus(datosActualizados.getStatus());

            // Actualizar autor si viene distinto
            if (datosActualizados.getAutor() != null && datosActualizados.getAutor().getId() != null) {
                Usuario autor = usuarioRepository.findById(datosActualizados.getAutor().getId())
                        .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
                temaExistente.setAutor(autor);
            }

            // Actualizar curso si viene distinto
            if (datosActualizados.getCurso() != null && datosActualizados.getCurso().getId() != null) {
                Curso curso = cursoRepository.findById(datosActualizados.getCurso().getId())
                        .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
                temaExistente.setCurso(curso);
            }

            return temaRepository.save(temaExistente);
        }).orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
    }
}
