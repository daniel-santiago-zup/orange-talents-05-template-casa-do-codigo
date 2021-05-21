package br.com.zupacademy.daniel.casadocodigo.config.validacao;

import br.com.zupacademy.daniel.casadocodigo.common.PaisEstadoId;
import br.com.zupacademy.daniel.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EstadoObrigatorioSeExisteNoPaisValidator implements ConstraintValidator<EstadoObrigatorioSeExisteNoPais, PaisEstadoId> {

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public void initialize(EstadoObrigatorioSeExisteNoPais constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(PaisEstadoId paisEstadoId, ConstraintValidatorContext constraintValidatorContext) {
        // Se entrar nessa condicional é porque existe estados nesse país
        if (estadoRepository.existsByPaisId(paisEstadoId.getIdPais())) {
            // Se entrar nessa condicional é porque foi fornecido um id de estado
            if (paisEstadoId.getIdEstado() != null) {
                // O id de estado fornecido deve existir e ser do país fornecido.
                return estadoRepository.existsByIdAndPaisId(paisEstadoId.getIdEstado(), paisEstadoId.getIdPais());
            }
            // Se não entrou na condicional acima é porque o pais tinha estados mas não foi fornecido nenhum
            return false;
        }
        /*Se não entrou na condicional acima é porque não existe estados nesse país. Então não pode ser fornecido
        * um id de estado*/
        return paisEstadoId.getIdEstado() == null;
    }
}
