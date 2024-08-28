package com.dieese.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Sindicato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String localizacao;

    @OneToMany(mappedBy = "sindicato")
    private List<Greve> greves;
}
