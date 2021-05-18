package br.com.zupacademy.daniel.casadocodigo.config.validacao;

import br.com.zupacademy.daniel.casadocodigo.model.Autor;
import br.com.zupacademy.daniel.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValorUnicoValidator implements ConstraintValidator<ValorUnico, String> {

    @PersistenceContext
    EntityManager entityManager;

    private Class<?> classe;
    private String campo;

    @Override
    public void initialize(ValorUnico constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.classe = constraintAnnotation.classe();
        this.campo = constraintAnnotation.campo();
    }

    @Override
    public boolean isValid(String valor, ConstraintValidatorContext constraintValidatorContext) {
        List<?> resultadosConsulta = entityManager.createQuery("select c from "+classe.getName()+" c where c."+campo+" = :pValor",this.classe)
                .setParameter("pValor",valor)
                .getResultList();


        return resultadosConsulta.isEmpty();
    }
}
