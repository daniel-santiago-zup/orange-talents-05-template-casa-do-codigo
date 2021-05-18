package br.com.zupacademy.daniel.casadocodigo.DTO;

import br.com.zupacademy.daniel.casadocodigo.model.Categoria;

public class CategoriaDTO {
    private String nome;

    public CategoriaDTO(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
