package com.dieese.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Greve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String motivo;
    @ElementCollection
    private List<String> categoriasTrabalhadores;
    private int numeroTrabalhadores;
    private String local;

    @ManyToOne
    @JoinColumn(name = "sindicato_id")
    @JsonBackReference
    private Sindicato sindicato;
}
