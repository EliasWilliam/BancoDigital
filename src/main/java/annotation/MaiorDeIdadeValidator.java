package annotation;

public class MaiorDeIdadeValidator implements ConstraintValidatorContext context, LocalDate> {

    @Override
    public void initiliaze(MaiorDeIdade constraintAnnotation){

    }

    @Override

    public boolean isValid(LocalDate value, ConstraintValidatorContext context){

        if(value == null){
        return false;
        }
        int anoNasc = value.getYear();
        int anoAtual = LocalDate.now().getYear();
        if((anoAtual - anoNasc)) < 18) {
        return false;
        }
        return true;
    }
}
