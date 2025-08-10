package com.bubches.forohub.service;

import com.bubches.forohub.model.Respuesta;
import com.bubches.forohub.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    public Respuesta guardar(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    public List<Respuesta> listarTodas() {
        return respuestaRepository.findAll();
    }
}
