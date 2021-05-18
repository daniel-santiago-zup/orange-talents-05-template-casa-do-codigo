package br.com.zupacademy.daniel.casadocodigo.config.validacao;

import br.com.zupacademy.daniel.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NomeUnicoCategoriaValidator implements ConstraintValidator<NomeUnicoCategoria, String> {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public void initialize(NomeUnicoCategoria constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {
        return !categoriaRepository.existsByNome(nome);
    }
}
