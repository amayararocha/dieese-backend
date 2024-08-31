package com.dieese.service;

import com.dieese.model.Greve;
import com.dieese.repository.GreveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreveService {

    @Autowired
    private GreveRepository greveRepository;

    public List<Greve> getAllGreves() {
        return greveRepository.findAll();
    }

    public Optional<Greve> getGreveById(Long id) {
        return greveRepository.findById(id);
    }

    public List<Greve> getGrevesByCategoria(String categoria) {
        return greveRepository.findByCategoriasTrabalhadoresContainingIgnoreCase(categoria);
    }

    public List<Greve> getGrevesBySindicato(String sindicato) {
        return greveRepository.findBySindicatoContainingIgnoreCase(sindicato);
    }

    public Greve saveGreve(Greve greve) throws DataIntegrityViolationException {
        return greveRepository.save(greve);
    }

    public Optional<Greve> updateGreve(Long id, Greve greve) {
        if (!greveRepository.existsById(id)) {
            return Optional.empty();
        }
        greve.setId(id);
        return Optional.of(greveRepository.save(greve));
    }

    public boolean deleteGreve(Long id) {
        if (greveRepository.existsById(id)) {
            greveRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
