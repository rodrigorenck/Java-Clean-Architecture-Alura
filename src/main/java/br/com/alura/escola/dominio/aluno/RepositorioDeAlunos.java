package br.com.alura.escola.dominio.aluno;

import java.util.List;

/**
 * Camadas mais externas vao usar essa interface para fazer a persistencia de alunos
 * Essa interface faz parte da camada de dominio logo ela nao deve depender de nenhum detalhe de infra - frameworks, libs...
 * Nas camadas de infra podemos persistir alunos de varias maneiras distintas - sem afetar essa classe
 */
public interface RepositorioDeAlunos {

    void matricular(Aluno aluno);
    List<Aluno> buscarTodos();
    void remover(Aluno aluno);
    Aluno buscarPorCpf(CPF cpf);

}
