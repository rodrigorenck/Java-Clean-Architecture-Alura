package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.CPF;

import java.util.List;

/**
 * Camadas mais externas vao usar essa interface para fazer a persistencia de alunos
 * Essa interface faz parte da camada de dominio logo ela nao deve depender de nenhum detalhe de infra - frameworks, libs...
 * Nas camadas de infra podemos persistir alunos de varias maneiras distintas - sem afetar essa classe
 * Aqui nos temos o conceito - O QUE - na infra nos temos o COMO vamos implementar esse conceito
 */
public interface RepositorioDeAlunos {

    void matricular(Aluno aluno);
    List<Aluno> buscarTodos();
    void remover(Aluno aluno);
    Aluno buscarPorCpf(CPF cpf);
}
