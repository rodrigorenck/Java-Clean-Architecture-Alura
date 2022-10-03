package br.com.alura.escola;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatriculadorDeAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.gamificacao.dominio.selo.GeraSeloAlunoNovatoOuvinte;
import br.com.alura.escola.gamificacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;
import br.com.alura.escola.gamificacao.infra.selo.RepositorioDeSelosEmMemoria;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculadoOuvinte;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;

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
        RepositorioDeSelos repositorioDeSelos = new RepositorioDeSelosEmMemoria();

        PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();
        publicadorDeEventos.adicionar(new LogDeAlunoMatriculadoOuvinte());
        publicadorDeEventos.adicionar(new GeraSeloAlunoNovatoOuvinte(repositorioDeSelos));

        MatriculadorDeAluno matricularAluno = new MatriculadorDeAluno(repositorioDeAlunos, publicadorDeEventos);

        matricularAluno.executa(dto);

        List<Aluno> alunos = repositorioDeAlunos.buscarTodos();
        System.out.println(alunos);

        CPF cpfObj = CPF.transforma(cpf);
        List<Selo> selos = repositorioDeSelos.buscarPorCpf(cpfObj);
        System.out.println(selos);
    }
}
