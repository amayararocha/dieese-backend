package com.dieese.service;

import com.dieese.model.Greve;
import com.dieese.model.Sindicato;
import com.dieese.repository.GreveRepository;
import com.dieese.repository.SindicatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreveService {

    @Autowired
    private GreveRepository greveRepository;

    @Autowired
    private SindicatoRepository sindicatoRepository;

    public Greve createGreve(Greve greve) {
        if (greve.getSindicato() != null && greve.getSindicato().getId() != null) {
            Sindicato sindicato = sindicatoRepository.findById(greve.getSindicato().getId())
                    .orElseThrow(() -> new RuntimeException("Sindicato não encontrado com o id: " + greve.getSindicato().getId()));
            greve.setSindicato(sindicato);
        }
        return greveRepository.save(greve);
    }

    public List<Greve> getAllGreves() {
        return greveRepository.findAll();
    }

    public Optional<Greve> getGreveById(Long id) {
        return greveRepository.findById(id);
    }

    public Greve updateGreve(Long id, Greve greveDetails) {
        Greve greve = greveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greve não encontrada com o id: " + id));

        greve.setDataInicio(greveDetails.getDataInicio());
        greve.setDataFim(greveDetails.getDataFim());
        greve.setMotivo(greveDetails.getMotivo());
        greve.setCategoriasTrabalhadores(greveDetails.getCategoriasTrabalhadores());
        greve.setNumeroTrabalhadores(greveDetails.getNumeroTrabalhadores());
        greve.setLocal(greveDetails.getLocal());

        if (greveDetails.getSindicato() != null && greveDetails.getSindicato().getId() != null) {
            Sindicato sindicato = sindicatoRepository.findById(greveDetails.getSindicato().getId())
                    .orElseThrow(() -> new RuntimeException("Sindicato não encontrado com o id: " + greveDetails.getSindicato().getId()));
            greve.setSindicato(sindicato);
        }

        return greveRepository.save(greve);
    }

    public void deleteGreve(Long id) {
        Greve greve = greveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greve não encontrada com o id: " + id));
        greveRepository.delete(greve);
    }
}
