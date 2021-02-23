package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = { EmailExistenteValidator.class})
@Target({FIELD})
@Retention({Runtime})


public @interface EmailExistente {
    String message () default "E-mail já existente.";
    Class<?>[] groups() default { };
    Class<?> extends Payload>[] payload() default { };

}
