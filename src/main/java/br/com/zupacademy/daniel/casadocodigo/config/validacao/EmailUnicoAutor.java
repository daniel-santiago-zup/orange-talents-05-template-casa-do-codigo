package br.com.zupacademy.daniel.casadocodigo.config.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailUnicoAutorValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailUnicoAutor {

    String message() default "Email deve ser único!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
