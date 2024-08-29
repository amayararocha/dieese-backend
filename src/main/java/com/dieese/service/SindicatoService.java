package com.dieese.service;

import com.dieese.model.Sindicato;
import com.dieese.repository.SindicatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SindicatoService {

    @Autowired
    private SindicatoRepository sindicatoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Sindicato createSindicato(Sindicato sindicato) {
        sindicato.setPassword(passwordEncoder.encode(sindicato.getPassword()));
        return sindicatoRepository.save(sindicato);
    }

    public List<Sindicato> getAllSindicatos() {
        return sindicatoRepository.findAll();
    }

    public Optional<Sindicato> getSindicatoById(Long id) {
        return sindicatoRepository.findById(id);
    }

    public Sindicato updateSindicato(Long id, Sindicato sindicatoDetails) {
        Sindicato sindicato = sindicatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sindicato não encontrado com o id: " + id));

        sindicato.setNome(sindicatoDetails.getNome());
        sindicato.setLocalizacao(sindicatoDetails.getLocalizacao());

        if (sindicatoDetails.getUsername() != null && !sindicatoDetails.getUsername().isEmpty()) {
            sindicato.setUsername(sindicatoDetails.getUsername());
        }

        if (sindicatoDetails.getPassword() != null && !sindicatoDetails.getPassword().isEmpty()) {
            sindicato.setPassword(passwordEncoder.encode(sindicatoDetails.getPassword()));
        }

        return sindicatoRepository.save(sindicato);
    }

    public void deleteSindicato(Long id) {
        Sindicato sindicato = sindicatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sindicato não encontrado com o id: " + id));

        sindicatoRepository.delete(sindicato);
    }

    public Optional<Sindicato> findByUsername(String username) {
        return sindicatoRepository.findByUsername(username);
    }
}
