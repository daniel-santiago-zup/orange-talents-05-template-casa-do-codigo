package br.com.zupacademy.daniel.casadocodigo.DTO;

import br.com.zupacademy.daniel.casadocodigo.model.Livro;


public class LivroDTO {

    private Long id;
    private String titulo;

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return this.id;
    }
    public String getTitulo() {
        return titulo;
    }

}
