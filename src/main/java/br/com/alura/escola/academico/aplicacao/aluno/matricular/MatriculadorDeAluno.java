package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;
import br.com.alura.escola.academico.dominio.aluno.AlunoMatriculadoEvento;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;

/**
 * Use Case - Servico
 * Fluxo de matricula de aluno
 * Padrao Command - executa uma acao
 */
public class MatriculadorDeAluno {

    private final RepositorioDeAlunos repositorio;
    private final PublicadorDeEventos publicadorDeEventos;


    public MatriculadorDeAluno(RepositorioDeAlunos repositorio, PublicadorDeEventos publicadorDeEventos) {
        this.repositorio = repositorio;
        this.publicadorDeEventos = publicadorDeEventos;
    }

    public void executa(MatricularAlunoDto dto){
        Aluno aluno = dto.criarAluno();
        repositorio.matricular(aluno);

        AlunoMatriculadoEvento evento = new AlunoMatriculadoEvento(aluno.getCpf());
        publicadorDeEventos.publicar(evento);
    }
}
