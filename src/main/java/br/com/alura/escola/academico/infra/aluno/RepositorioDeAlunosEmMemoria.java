package br.com.alura.escola.academico.infra.aluno;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.AlunoNaoEncontrado;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosEmMemoria implements RepositorioDeAlunos {

    private List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        matriculados.add(aluno);
    }

    @Override
    public List<Aluno> buscarTodos() {
        return matriculados;
    }

    @Override
    public void remover(Aluno aluno) {
        matriculados.removeIf(a -> a.equals(aluno));
    }

    @Override
    public Aluno buscarPorCpf(CPF cpf) {
        return matriculados.stream()
                .filter(a -> a.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(()-> new AlunoNaoEncontrado(cpf));
    }
}
