package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;

/**
 * Use Case - Servico
 * Fluxo de matricula de aluno
 * Padrao Command - executa uma acao
 */
public class MatriculadorDeAluno {

    private final RepositorioDeAlunos repositorio;


    public MatriculadorDeAluno(RepositorioDeAlunos repositorio) {
        this.repositorio = repositorio;
    }

    public void executa(MatricularAlunoDto dto){
        Aluno aluno = dto.criarAluno();
        repositorio.matricular(aluno);
    }
}
