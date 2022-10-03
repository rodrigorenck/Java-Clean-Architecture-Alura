package br.com.alura.escola;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.alura.escola.academico.dominio.aluno.AlunoBuilder;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;

import java.util.List;

/**
 * Simula uma interface grafica - pegariamos esse dado de alguma api
 */
public class ExemploDeUsoDaAplicacao {

    public static void main(String[] args) {

        //fluxo de matricula de aluno - independente de ondem vierem os dados eu sempre vou seguir esse
        //use case - deve estar dentro da camada de aplicacao para podermos reaproveitar independete de onde pegarmos os dados
        AlunoBuilder.builder().build();
        Aluno rodrigo = AlunoBuilder.builder()
                .comNome("Rodrigo")
                .comCpf("444.333.220-13")
                .comEmail("rodrigo@email.com")
                .comTelefone("55", "999999999")
                .build();

        RepositorioDeAlunos repositorio = new RepositorioDeAlunosEmMemoria();

        repositorio.matricular(rodrigo);

        List<Aluno> alunos = repositorio.buscarTodos();

        System.out.println(alunos);
    }
}
