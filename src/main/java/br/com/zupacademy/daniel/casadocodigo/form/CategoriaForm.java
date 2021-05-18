package br.com.zupacademy.daniel.casadocodigo.form;

import br.com.zupacademy.daniel.casadocodigo.config.validacao.NomeUnicoCategoria;
import br.com.zupacademy.daniel.casadocodigo.model.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {
    @NotBlank
    @NomeUnicoCategoria
    private String nome;

    public CategoriaForm() {}

    public CategoriaForm(String nome) {
        this.nome = nome;
    }

    public Categoria converte() {
        return new Categoria(this.nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
