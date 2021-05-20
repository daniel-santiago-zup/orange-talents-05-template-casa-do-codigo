package br.com.zupacademy.daniel.casadocodigo.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @URL
    @Size(max = 2048)
    private String urlFotoPerfil;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Length(max = 400)
    private String descricao;

    private LocalDateTime dataDeRegistro;

    @Deprecated
    public Autor() {}

    public Autor(@NotBlank String nome,
                 @NotBlank @URL @Size(max = 2048) String urlFotoPerfil,
                 @NotBlank @Email String email,
                 @NotBlank @Length(max = 400) String descricao) {
        this.nome = nome;
        this.urlFotoPerfil = urlFotoPerfil;
        this.email = email;
        this.descricao = descricao;
        this.dataDeRegistro = LocalDateTime.now();
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
