package br.com.zupacademy.daniel.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"nome"}))
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Deprecated
    public Categoria() {}

    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
