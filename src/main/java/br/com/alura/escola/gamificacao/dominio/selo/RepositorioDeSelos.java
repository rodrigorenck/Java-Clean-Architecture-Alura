package br.com.alura.escola.gamificacao.dominio.selo;

import br.com.alura.escola.shared.dominio.CPF;

import java.util.List;

public interface RepositorioDeSelos {

    boolean cadastrar(Selo selo);
    boolean deletar(Selo selo);
    List<Selo> buscarTodos();
    List<Selo> buscarPorCpf(CPF cpf);
}
