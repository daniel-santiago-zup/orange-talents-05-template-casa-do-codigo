package br.com.zupacademy.daniel.casadocodigo.DTO;

import br.com.zupacademy.daniel.casadocodigo.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDTO {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroDePaginas;
    private String isbn;
    private LocalDate dataDePublicacao;
    private CategoriaDTO categoria;
    private AutorDTO autor;

    public LivroDTO(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.dataDePublicacao = livro.getDataDePublicacao();
        this.categoria = new CategoriaDTO(livro.getCategoria());
        this.autor = new AutorDTO(livro.getAutor());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public AutorDTO getAutor() {
        return autor;
    }
}
