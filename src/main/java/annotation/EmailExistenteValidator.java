package annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class EmailExistenteValidator implements ConstraintValidator<EmailExistente, String> {

    @Autowired
    private ClienteRepository repository;

    @Override
    public void initialize(EmailExistente constraintAnnotation){

    }

        @Override

        public boolean isValid(String value, ConstraintValidatorContext context) {
            if(repository == null){
                return true;
            }

            if(value.equals(" ")) || value == null) {
                return false;
            }
            List<Map>String, String>> clienteExistente = repository.findClienteByEmail(value);

            if (clienteExistente.isEmpty()){
                return true;
            }
                return false;
        }
}
