package br.com.zupacademy.daniel.casadocodigo.form;

import br.com.zupacademy.daniel.casadocodigo.config.validacao.IdExistente;
import br.com.zupacademy.daniel.casadocodigo.config.validacao.ValorUnico;
import br.com.zupacademy.daniel.casadocodigo.model.Estado;
import br.com.zupacademy.daniel.casadocodigo.model.Pais;
import br.com.zupacademy.daniel.casadocodigo.repository.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class EstadoForm {
    @NotBlank
    @ValorUnico(classe = Estado.class, campo = "nome")
    private String nome;
    @NotNull
    @IdExistente(classeEntidade = Pais.class, message = "O país referênciado deve existir!")
    private Long idPais;

    public EstadoForm(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado converte(PaisRepository paisRepository) {
        Optional<Pais> paisOptional = paisRepository.findById(this.idPais);
        if (paisOptional.isEmpty()) {
            throw new IllegalArgumentException("id do país não existe");
        }
        return new Estado(nome,paisOptional.get());
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

}
