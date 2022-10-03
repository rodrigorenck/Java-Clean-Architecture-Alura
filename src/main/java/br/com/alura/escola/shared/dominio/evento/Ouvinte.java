package br.com.alura.escola.shared.dominio.evento;

/**
 * Ouvinte generico
 * Classe que vai disparar o processamento do evento
 */
public abstract class Ouvinte {

    //template method pattern
    public void processa(Evento evento){
        if(deveProcessar(evento)){
            reageAo(evento);
        }
    }


    //subclasses que implementam
    public abstract void reageAo(Evento evento);

    //quem vai dzer se tem que processar ou nao o evento eh a propria classe
    public abstract boolean deveProcessar(Evento evento);

}
