package com.bubches.forohub.controller;

import com.bubches.forohub.model.Tema;
import com.bubches.forohub.service.TemaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temas")
public class TemaController {

    @Autowired
    private TemaService temaService;

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Tema tema, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            var errores = bindingResult.getFieldErrors()
                    .stream()
                    .map(e -> e.getField() + ": " + e.getDefaultMessage())
                    .toList();
            return ResponseEntity.badRequest().body(errores);
        }
        try {
            Tema nuevo = temaService.guardar(tema);
            return ResponseEntity.ok(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Tema>> listarTodos() {
        return ResponseEntity.ok(temaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> buscarPorId(@PathVariable Long id) {
        return temaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Tema datosActualizados,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            var errores = bindingResult.getFieldErrors()
                    .stream()
                    .map(e -> e.getField() + ": " + e.getDefaultMessage())
                    .toList();
            return ResponseEntity.badRequest().body(errores);
        }

        return temaService.buscarPorId(id)
                .map(temaExistente -> {
                    try {
                        Tema temaActualizado = temaService.actualizarTema(id, datosActualizados);
                        return ResponseEntity.ok(temaActualizado);
                    } catch (RuntimeException e) {
                        return ResponseEntity.badRequest().body(e.getMessage());
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (temaService.buscarPorId(id).isPresent()) {
            temaService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
