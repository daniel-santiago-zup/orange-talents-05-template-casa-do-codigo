package br.com.zupacademy.daniel.casadocodigo.config.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdExistenteValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdExistente {
    String message() default "Valor deve existir no banco de dados!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<?> classeEntidade();
    String nomeCampoId() default "id";
    Class<?> tipoCampoId() default Long.class;
}
