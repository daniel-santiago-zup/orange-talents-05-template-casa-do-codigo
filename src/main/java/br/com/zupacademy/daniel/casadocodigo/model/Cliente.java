package br.com.zupacademy.daniel.casadocodigo.model;

import br.com.zupacademy.daniel.casadocodigo.config.validacao.CpfOuCnpj;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @CpfOuCnpj
    private String cpfCnpj;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @ManyToOne
    @NotNull
    private Pais pais;
    @ManyToOne
    private Estado estado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    @Deprecated
    public Cliente() {}

    public Cliente(String email,
                   String nome,
                   String sobrenome,
                   String cpfCnpj,
                   String endereco,
                   String complemento,
                   String cidade,
                   Pais pais,
                   String telefone,
                   String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
