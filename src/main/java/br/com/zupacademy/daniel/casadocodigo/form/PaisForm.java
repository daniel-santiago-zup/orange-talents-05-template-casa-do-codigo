package br.com.zupacademy.daniel.casadocodigo.form;

import br.com.zupacademy.daniel.casadocodigo.config.validacao.ValorUnico;
import br.com.zupacademy.daniel.casadocodigo.model.Pais;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class PaisForm {
    @NotBlank
    @ValorUnico(classe = Pais.class, campo = "nome")
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PaisForm(String nome) {
        this.nome = nome;
    }

    public Pais converte() {
        return new Pais(nome);
    }
}
