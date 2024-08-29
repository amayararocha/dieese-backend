package com.dieese.controller;

import com.dieese.model.Greve;
import com.dieese.repository.GreveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greves")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GreveController {

    @Autowired
    private GreveRepository greveRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Greve>> getAll() {
        List<Greve> greves = greveRepository.findAll();
        return ResponseEntity.ok(greves);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greve> getById(@PathVariable Long id) {
        Optional<Greve> greve = greveRepository.findById(id);
        return greve.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Greve> postGreve(@RequestBody @Valid Greve greve) {
        try {
            Greve savedGreve = greveRepository.save(greve);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedGreve);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Greve> putGreve(@RequestBody @Valid Greve greve) {
        if (greveRepository.existsById(greve.getId())) {
            Greve updatedGreve = greveRepository.save(greve);
            return ResponseEntity.ok(updatedGreve);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteGreve(@PathVariable Long id) {
        if (greveRepository.existsById(id)) {
            greveRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
