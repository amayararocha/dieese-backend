package com.dieese.repository;

import com.dieese.model.Sindicato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SindicatoRepository extends JpaRepository<Sindicato, Long> {
    Optional<Sindicato> findByUsername(String username);
}
