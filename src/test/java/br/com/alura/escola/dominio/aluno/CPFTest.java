package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.aluno.CPF;
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