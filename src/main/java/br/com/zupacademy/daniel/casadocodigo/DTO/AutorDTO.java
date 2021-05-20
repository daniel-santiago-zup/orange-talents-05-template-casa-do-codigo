package br.com.zupacademy.daniel.casadocodigo.DTO;

import br.com.zupacademy.daniel.casadocodigo.model.Autor;

public class AutorDTO {

    private String nome;
    private String urlFotoPerfil;
    private String email;
    private String descricao;

    public AutorDTO(Autor autor) {
        this.nome = autor.getNome();
        this.urlFotoPerfil = autor.getUrlFotoPerfil();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getUrlFotoPerfil() {
        return urlFotoPerfil;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
