package br.com.alura.escola.academico.dominio.aluno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    @Test
    void deveriaJogarUmaExceptionCasoTenteCadastrarMaisDeDoisNumerosDeTelefone() {

        assertThrows(TelefoneException.class, () -> {
            Aluno build = AlunoBuilder.builder()
                    .comTelefone("222", "3333333")
                    .comTelefone("222", "3333333")
                    .comTelefone("222", "3333333")
                    .build();
        });
    }

    @Test
    void naoDeveriaJogarExceptionParaAteDoisNumerosCadastrados() {
        Aluno aluno = AlunoBuilder.builder()
                .comTelefone("222", "3333333")
                .comTelefone("111", "11111111")
                .build();

        assertAll(() -> {
                    assertEquals(2, aluno.getTelefones().size());
                },
                () -> {
                    assertEquals("222 3333333", aluno.getTelefones().get(0).toString());
                },
                () -> {
                    assertEquals("111 11111111", aluno.getTelefones().get(1).toString());
                });
    }
}