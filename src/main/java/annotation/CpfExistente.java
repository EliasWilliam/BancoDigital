package annotation;



import static java.lang.annotation.ElemenType.FIELD;
import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = { CpfExistenteValidator.class})
@Target({FIELD})
@Retention(RUNTIME)



public @Interface CpfExistente {
    String message() default "Cpf já cadastrado";

    class<?>[] groups() default { };
    
    Class<? extends Payload>[] payload() default { };
}
