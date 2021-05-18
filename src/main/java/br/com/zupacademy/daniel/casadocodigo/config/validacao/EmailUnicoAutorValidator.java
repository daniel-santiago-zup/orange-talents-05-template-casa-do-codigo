package br.com.zupacademy.daniel.casadocodigo.config.validacao;

import br.com.zupacademy.daniel.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUnicoAutorValidator implements ConstraintValidator<EmailUnicoAutor, String> {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public void initialize(EmailUnicoAutor constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !autorRepository.existsByEmail(email);
    }
}
