package br.com.alura.escola.dominio.aluno;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * VALUE OBJECT - quando nao eh uma entidade - se tiver o mesmo valor sera igual
 * Nao tem identificador unico
 */
public class Email {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);


    private String endereco;

    public Email(String endereco) {
        validarEmail(endereco);
        this.endereco = endereco;
    }

    private void validarEmail(String endereco){
//        Matcher matcher = pattern.matcher(EMAIL_PATTERN);
//        if(endereco == null || !matcher.matches()){
//            throw new IllegalArgumentException("Email invalido");
//        }
    }

    public String getEndereco() {
        return this.endereco;
    }

    @Override
    public String toString() {
        return endereco;
    }
}
