package br.com.zupacademy.daniel.casadocodigo.config.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValorUnicoValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValorUnico {
    String message() default "Valor deve ser único!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<?> classe();
    String campo();
}
