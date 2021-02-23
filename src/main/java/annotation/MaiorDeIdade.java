package annotation;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@HttpConstraint
@Target({FIELD})
@Retention(RUNTIME)
public @interface MaiorDeIdade {

    String message() default "Apenas maior de idade para realizar o registro.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
