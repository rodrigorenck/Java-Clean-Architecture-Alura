package br.com.alura.escola;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.AlunoBuilder;

public class TestandoBuilderAluno {

    public static void main(String[] args) {

        Aluno rodrigo = AlunoBuilder.builder()
                .comNome("Rodrigo")
                .comEmail("1234567")
                .comCpf("1234")
                .comTelefone("123", "456")
                .comTelefone("333", "45678")
                .build();

        //vai jogar exception por causa das verificacoes

    }
}
