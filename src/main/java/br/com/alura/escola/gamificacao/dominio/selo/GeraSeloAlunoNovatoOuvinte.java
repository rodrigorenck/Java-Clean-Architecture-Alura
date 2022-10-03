package br.com.alura.escola.gamificacao.dominio.selo;

import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.Ouvinte;
import br.com.alura.escola.shared.dominio.evento.TipoEvento;

import java.util.Map;

public class GeraSeloAlunoNovatoOuvinte extends Ouvinte {

    private final RepositorioDeSelos repositorioDeSelos;

    public GeraSeloAlunoNovatoOuvinte(RepositorioDeSelos repositorioDeSelos) {
        this.repositorioDeSelos = repositorioDeSelos;
    }

    @Override
    public void reageAo(Evento evento) {
        Map<String, Object> informacoes = evento.informacoes();
        CPF cpf = (CPF) informacoes.get("cpf");
        Selo seloNovato = new Selo(cpf, "NOVATO");
        repositorioDeSelos.cadastrar(seloNovato);
    }

    @Override
    public boolean deveProcessar(Evento evento) {
        return evento.evento() == (TipoEvento.ALUNO_MATRICULADO);
    }
}
