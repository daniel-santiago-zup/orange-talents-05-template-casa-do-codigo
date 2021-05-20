package br.com.zupacademy.daniel.casadocodigo.DTO;

import br.com.zupacademy.daniel.casadocodigo.model.Livro;

import java.math.BigDecimal;

public class LivroDetalheDTO {

    private String titulo;
    private String subtitulo;
    private String urlCapa;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroDePaginas;
    private String isbn;
    private AutorDTO autorDTO;

    public LivroDetalheDTO(Livro livro) {
        this.titulo = livro.getTitulo();
        this.subtitulo = livro.getSubtitulo();
        this.urlCapa = livro.getUrlCapa();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.autorDTO = new AutorDTO(livro.getAutor());
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

    public AutorDTO getAutorDTO() {
        return autorDTO;
    }

    public String getUrlCapa() {
        return urlCapa;
    }

    public String getSubtitulo() {
        return subtitulo;
    }
}
