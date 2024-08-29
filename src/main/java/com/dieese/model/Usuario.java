package com.dieese.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "tb_usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Atributo Nome é Obrigatório!")
    private String nome;

    private String localizacao;

    @Schema(example = "email@email.com.br")
    @NotBlank(message = "O Atributo Usuário é Obrigatório!")
    @Email(message = "O Atributo Usuário deve ser um email válido!")
    private String usuario;

    @NotBlank(message = "O Atributo Senha é Obrigatório!")
    @Size(min = 8, message = "A Senha deve ter no mínimo 8 caracteres")
    private String senha;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Greve> greves;
}
