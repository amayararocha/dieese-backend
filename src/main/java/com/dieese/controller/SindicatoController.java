package com.dieese.controller;

import com.dieese.model.Sindicato;
import com.dieese.resquest.LoginRequest;
import com.dieese.service.SindicatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sindicatos")
public class SindicatoController {

    @Autowired
    private SindicatoService sindicatoService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        if (sindicatoService.authenticate(loginRequest.getUsername(), loginRequest.getPassword())) {
            return ResponseEntity.ok("Login bem-sucedido");
        }
        return ResponseEntity.status(401).body("Credenciais inválidas");
    }

    @PostMapping
    public ResponseEntity<Sindicato> createSindicato(@RequestBody Sindicato sindicato) {
        return ResponseEntity.ok(sindicatoService.createSindicato(sindicato));
    }

    @GetMapping
    public ResponseEntity<List<Sindicato>> getAllSindicatos() {
        return ResponseEntity.ok(sindicatoService.getAllSindicatos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sindicato> getSindicatoById(@PathVariable Long id) {
        return sindicatoService.getSindicatoById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sindicato> updateSindicato(@PathVariable Long id, @RequestBody Sindicato sindicatoDetails) {
        return ResponseEntity.ok(sindicatoService.updateSindicato(id, sindicatoDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSindicato(@PathVariable Long id) {
        sindicatoService.deleteSindicato(id);
        return ResponseEntity.noContent().build();
    }
}
