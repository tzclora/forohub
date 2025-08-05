package com.bubches.forohub.repository;

import com.bubches.forohub.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Long> {
    // puedes agregar métodos personalizados si necesitas
}
