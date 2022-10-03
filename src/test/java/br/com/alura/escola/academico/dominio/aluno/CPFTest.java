package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.CPF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {


    @Test
    void deveriaJogarUmaExceptionParaCpfInvalido(){
        assertThrows(IllegalArgumentException.class, ()->{
            new CPF("123");
        });
    }

    @Test
    void deveriaAceitarCpfValido(){
        String numeroCpf = "123.456.798-10";
        CPF cpf = new CPF(numeroCpf);
    }
}