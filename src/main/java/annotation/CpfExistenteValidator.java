package annotation;

import com.example.Banco.repository.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Map;


public class CpfExistenteValidator implements ConstraintValidator<CpfExistente,String> {

    @Autowired
    private ClienteRepository repository;

    @Override
    public void initialize(CpfExistente constraintannotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        if(repository == null){
            return true;
        }
        if(value.equals("") || value == null {
            return false;
        }

        List<Map<String, String>> clienteExistente = repository.findClienteByCpf(value);
        if (clienteExistente.isEmpty()) {
            return true;
        }
        return false;
    }
}
