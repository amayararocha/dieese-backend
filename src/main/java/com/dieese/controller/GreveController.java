package com.dieese.controller;

import com.dieese.model.Greve;
import com.dieese.service.GreveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/greves")
public class GreveController {

    @Autowired
    private GreveService greveService;

    @PostMapping
    public ResponseEntity<Greve> createGreve(@RequestBody Greve greve) {
        try {
            Greve createdGreve = greveService.createGreve(greve);
            return ResponseEntity.ok(createdGreve);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Greve>> getAllGreves() {
        List<Greve> greves = greveService.getAllGreves();
        return ResponseEntity.ok(greves);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greve> getGreveById(@PathVariable Long id) {
        Optional<Greve> greve = greveService.getGreveById(id);
        return greve.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Greve> updateGreve(@PathVariable Long id, @RequestBody Greve greveDetails) {
        try {
            Greve updatedGreve = greveService.updateGreve(id, greveDetails);
            return ResponseEntity.ok(updatedGreve);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGreve(@PathVariable Long id) {
        try {
            greveService.deleteGreve(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
