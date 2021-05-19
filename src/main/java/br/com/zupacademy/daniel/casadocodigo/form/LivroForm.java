package br.com.zupacademy.daniel.casadocodigo.form;

import br.com.zupacademy.daniel.casadocodigo.config.validacao.IdExistente;
import br.com.zupacademy.daniel.casadocodigo.config.validacao.ValorUnico;
import br.com.zupacademy.daniel.casadocodigo.model.Autor;
import br.com.zupacademy.daniel.casadocodigo.model.Categoria;
import br.com.zupacademy.daniel.casadocodigo.model.Livro;
import br.com.zupacademy.daniel.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.daniel.casadocodigo.repository.CategoriaRepository;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroForm {

    @NotBlank
    @ValorUnico(classe = Livro.class, campo = "titulo")
    private String titulo;
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
    @ValorUnico(classe = Livro.class, campo = "isbn")
    @ISBN(type = ISBN.Type.ANY)
    private String isbn;
    @Future
    private LocalDate dataDePublicacao;
    @NotNull
    @IdExistente(classeEntidade = Categoria.class)
    private Long idCategoria;
    @NotNull
    @IdExistente(classeEntidade = Autor.class)
    private Long idAutor;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public LivroForm(String titulo,
                 String resumo,
                 String sumario,
                 BigDecimal preco,
                 Integer numeroDePaginas,
                 String isbn,
                 @JsonFormat(pattern = "dd/MM/yyyy") LocalDate dataDePublicacao,
                 Long idCategoria,
                 Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
        this.idAutor = idAutor;
        this.idCategoria = idCategoria;
    }

    public Livro convert(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
        Categoria categoria = categoriaRepository.findById(this.idCategoria).get();
        Autor autor = autorRepository.getOne(this.idAutor);

        return new Livro(this.titulo,
                this.resumo,
                this.sumario,
                this.preco,
                this.numeroDePaginas,
                this.isbn,
                this.dataDePublicacao,
                categoria,
                autor);
    }
}
