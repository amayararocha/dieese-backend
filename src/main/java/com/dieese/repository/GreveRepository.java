package com.dieese.repository;

import com.dieese.model.Greve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GreveRepository extends JpaRepository<Greve, Long> {
    List<Greve> findByCategoriasTrabalhadoresContainingIgnoreCase(String categoria);
    List<Greve> findBySindicatoContainingIgnoreCase(String sindicato);
}
