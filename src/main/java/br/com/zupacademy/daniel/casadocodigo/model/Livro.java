package br.com.zupacademy.daniel.casadocodigo.model;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"titulo","isbn"}))
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    private String subtitulo;
    @NotBlank
    @URL
    @Size(max = 2048)
    private String urlCapa;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @Lob
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @NotNull
    @Min(100)
    private Integer numeroDePaginas;
    @NotBlank
    @ISBN(type = ISBN.Type.ANY)
    private String isbn;
    @Future
    private LocalDate dataDePublicacao;
    @ManyToOne
    @NotNull
    private Categoria categoria;
    @ManyToOne
    @NotNull
    private Autor autor;

    @Deprecated
    public Livro() {}

    public Livro(@NotBlank String titulo,
                 String subtitulo,
                 @NotBlank @URL @Size(max = 2048) String urlCapa,
                 @NotBlank @Size(max = 500) String resumo,
                 String sumario,
                 @NotNull @Min(20) BigDecimal preco,
                 @NotNull @Min(100) Integer numeroDePaginas,
                 @NotBlank String isbn,
                 @Future LocalDate dataDePublicacao,
                 @NotNull Categoria categoria,
                 @NotNull Autor autor) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.urlCapa = urlCapa;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return this.id;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getUrlCapa() {
        return urlCapa;
    }

    public String getSubtitulo() {
        return subtitulo;
    }
}
