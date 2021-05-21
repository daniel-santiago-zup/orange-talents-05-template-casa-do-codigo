package br.com.zupacademy.daniel.casadocodigo.common;

import br.com.zupacademy.daniel.casadocodigo.config.validacao.IdExistente;
import br.com.zupacademy.daniel.casadocodigo.model.Pais;

import javax.validation.constraints.NotNull;

public class PaisEstadoId {
    @NotNull
    @IdExistente(classeEntidade = Pais.class)
    private final Long idPais;
    private final Long idEstado;

    public PaisEstadoId(Long idPais, Long idEstado) {
        this.idPais = idPais;
        this.idEstado = idEstado;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }
}
