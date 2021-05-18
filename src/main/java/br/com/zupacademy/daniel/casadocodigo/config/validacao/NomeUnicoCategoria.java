package br.com.zupacademy.daniel.casadocodigo.config.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = NomeUnicoCategoriaValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface NomeUnicoCategoria {
    String message() default "nome da categoria não pode ser duplicado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
