package br.com.zupacademy.daniel.casadocodigo.DTO;

import br.com.zupacademy.daniel.casadocodigo.model.Autor;

public class AutorDTO {

    private String nome;
    private String email;
    private String descricao;

    public AutorDTO(Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
