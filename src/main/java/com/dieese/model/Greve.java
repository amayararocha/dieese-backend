package com.dieese.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "tb_greves")
public class Greve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo data de inicío é Obrigatório!")
    private LocalDate dataInicio;

    @NotBlank(message = "O atributo data final é Obrigatório!")
    private LocalDate dataFim;

    @NotBlank(message = "O atributo motivo é Obrigatório!")
    @Size(min = 5, max = 100, message = "O atributo motivo deve conter no mínimo 05 e no máximo 100 caracteres")
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
