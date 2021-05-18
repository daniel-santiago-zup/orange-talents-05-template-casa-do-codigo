package br.com.zupacademy.daniel.casadocodigo.form;

import br.com.zupacademy.daniel.casadocodigo.config.validacao.ValorUnico;
import br.com.zupacademy.daniel.casadocodigo.model.Categoria;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {
    @NotBlank
    @ValorUnico(classe = Categoria.class, campo = "nome", message = "nome deve ser unico!")
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CategoriaForm(String nome) {
        this.nome = nome;
    }

    public Categoria converte() {
        return new Categoria(this.nome);
    }
}
