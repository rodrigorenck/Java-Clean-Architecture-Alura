package br.com.alura.escola;

import br.com.alura.escola.aplicacao.aluno.matricular.MatriculadorDeAluno;
import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

import java.util.List;

/**
 * Simula uma interface grafica - pegariamos esse dado de alguma api
 */
public class ExemploDeUsoDaAplicacaoUseCase {

    public static void main(String[] args) {
        String nome = "Jorge";
        String cpf = "111.111.111-11";
        String email = "rodrigo@email.com";

        MatricularAlunoDto dto = new MatricularAlunoDto(cpf, nome, email, "11", "1111111");

        RepositorioDeAlunos repositorioDeAlunos = new RepositorioDeAlunosEmMemoria();

        MatriculadorDeAluno matricularAluno = new MatriculadorDeAluno(repositorioDeAlunos);

        matricularAluno.executa(dto);

        List<Aluno> alunos = repositorioDeAlunos.buscarTodos();
        System.out.println(alunos);
    }
}
