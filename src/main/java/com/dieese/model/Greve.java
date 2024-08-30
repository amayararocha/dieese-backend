package com.dieese.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "O atributo data de início é Obrigatório!")
    private LocalDate dataInicio;

    @NotNull(message = "O atributo data final é Obrigatório!")
    private LocalDate dataFim;

    @NotBlank(message = "O atributo motivo é Obrigatório!")
    @Size(min = 5, max = 100, message = "O atributo motivo deve conter no mínimo 05 e no máximo 100 caracteres")
    private String motivo;

    @NotEmpty(message = "O atributo categoria é Obrigatório!")
    private String categoriasTrabalhadores;

    @NotNull(message = "O atributo número de trabalhadores é Obrigatório!")
    private int numeroTrabalhadores;

    @NotBlank(message = "O atributo local é Obrigatório!")
    private String local;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonBackReference
    private Usuario usuario;
}
