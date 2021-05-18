package br.com.zupacademy.daniel.casadocodigo.form;

import br.com.zupacademy.daniel.casadocodigo.config.validacao.ValorUnico;
import br.com.zupacademy.daniel.casadocodigo.model.Autor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AutorForm {

    @NotEmpty
    private String nome;
    @NotEmpty
    @Email
    @ValorUnico(classe = Autor.class, campo = "email", message = "email deve ser unico!")
    private String email;
    @NotEmpty
    @Length(max = 400)
    private String descricao;


    public AutorForm(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converte() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
