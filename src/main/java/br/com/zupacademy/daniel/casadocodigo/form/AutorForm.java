package br.com.zupacademy.daniel.casadocodigo.form;

import br.com.zupacademy.daniel.casadocodigo.config.validacao.ValorUnico;
import br.com.zupacademy.daniel.casadocodigo.model.Autor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorForm {

    @NotBlank
    private String nome;
    @NotBlank
    private String urlFotoPerfil;
    @NotBlank
    @Email
    @ValorUnico(classe = Autor.class, campo = "email", message = "email deve ser unico!")
    private String email;
    @NotBlank
    @Length(max = 400)
    private String descricao;


    public AutorForm(String nome, String urlFotoPerfil, String email, String descricao) {
        this.nome = nome;
        this.urlFotoPerfil = urlFotoPerfil;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converte() {
        return new Autor(this.nome, this.urlFotoPerfil, this.email, this.descricao);
    }
}
