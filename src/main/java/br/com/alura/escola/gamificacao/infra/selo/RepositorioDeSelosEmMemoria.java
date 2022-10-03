package br.com.alura.escola.gamificacao.infra.selo;

import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.gamificacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelos {

    private List<Selo> listSelos = new ArrayList<>();

    @Override
    public boolean cadastrar(Selo selo) {
        for (Selo s :
                listSelos) {
            if(s.equals(selo)) return false;
        }
        listSelos.add(selo);
        return true;
    }

    @Override
    public boolean deletar(Selo selo) {
        for (Selo s :
                listSelos) {
            if(s.equals(selo)){
                listSelos.remove(s);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Selo> buscarTodos() {
        return listSelos;
    }

    @Override
    public List<Selo> buscarPorCpf(CPF cpf) {
        return listSelos.stream()
                .filter(s -> s.getCpfDoAluno().equals(cpf))
                .collect(Collectors.toList());
    }
}
