package br.com.zupacademy.daniel.casadocodigo.model;

import br.com.zupacademy.daniel.casadocodigo.config.validacao.NomeUnicoCategoria;

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

    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
