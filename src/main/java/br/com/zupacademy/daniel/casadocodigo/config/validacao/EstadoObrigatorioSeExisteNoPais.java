package br.com.zupacademy.daniel.casadocodigo.config.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EstadoObrigatorioSeExisteNoPaisValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EstadoObrigatorioSeExisteNoPais {
    String message() default "O estado é obrigatório se o pais possui estados";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
