package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.aluno.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void deveriaJogarExceptionParaEmailInvalido(){

        assertThrows(IllegalArgumentException.class, () ->{
            new Email(null);
        });

        assertThrows(IllegalArgumentException.class, () ->{
            new Email("emailInvalido");
        });
        assertThrows(IllegalArgumentException.class, () ->{
            new Email("12345");
        });
    }

}