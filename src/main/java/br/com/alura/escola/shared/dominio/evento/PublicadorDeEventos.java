package br.com.alura.escola.shared.dominio.evento;

import java.util.ArrayList;
import java.util.List;

/**
 * Publicador de eventos generico
 */
public class PublicadorDeEventos {

    private List<Ouvinte> ouvintes = new ArrayList<>();


    public void adicionar(Ouvinte ouvinte){
        ouvintes.add(ouvinte);
    }

    public void publicar(Evento evento){
        ouvintes.forEach(o -> o.processa(evento));
    }
}