package com.dieese.controller;

import com.dieese.model.Greve;
import com.dieese.service.GreveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    private GreveService greveService;

    @GetMapping
    public ResponseEntity<List<Greve>> getAll() {
        List<Greve> greves = greveService.getAllGreves();
        return ResponseEntity.ok(greves);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greve> getById(@PathVariable Long id) {
        Optional<Greve> greve = greveService.getGreveById(id);
        return greve.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Greve> postGreve(@RequestBody @Valid Greve greve) {
        try {
            Greve savedGreve = greveService.saveGreve(greve);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedGreve);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Greve> putGreve(@PathVariable Long id, @RequestBody @Valid Greve greve) {
        try {
            Optional<Greve> updatedGreve = greveService.updateGreve(id, greve);
            return updatedGreve.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGreve(@PathVariable Long id) {
        if (greveService.deleteGreve(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
