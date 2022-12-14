package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculadoOuvinte;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MatriculadorDeAlunoTest {


//    @Test
//    public void deveriaSalvarAlunoBanco(){
//        RepositorioDeAlunos repositorio = Mockito.mock(RepositorioDeAlunosEmMemoria.class);
//        MatriculadorDeAluno matriculador = new MatriculadorDeAluno(repositorio);
//
//        MatricularAlunoDto aluno = new MatricularAlunoDto("123.123.123-13", "Rodrigo", "rodrigo@email","123","56789");
//        matriculador.executa(aluno);
//
//        Mockito.verify(repositorio).matricular(Mockito.any());
//    }

    @Test
    void deveriaSalvarAlunoNoBanco(){
        String nome = "Jorge";
        String cpf = "111.111.111-11";
        String email = "rodrigo@email.com";

        MatricularAlunoDto dto = new MatricularAlunoDto(cpf, nome, email, "11", "1111111");
        Aluno alunoCriado = dto.criarAluno();

        RepositorioDeAlunos repositorioDeAlunos = new RepositorioDeAlunosEmMemoria();

        PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();
        publicadorDeEventos.adicionar(new LogDeAlunoMatriculadoOuvinte());

        MatriculadorDeAluno matricularAluno = new MatriculadorDeAluno(repositorioDeAlunos, publicadorDeEventos);

        matricularAluno.executa(dto);

        CPF cpfObj = new CPF(cpf);
        Aluno alunoEncontrado = repositorioDeAlunos.buscarPorCpf(cpfObj);

        assertEquals(alunoEncontrado, alunoCriado);
    }

}