package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.evento.Ouvinte;
import br.com.alura.escola.shared.dominio.evento.Evento;

import java.time.format.DateTimeFormatter;


/**
 * Ouvinte do evento de AlunoMatriculado
 */
public class LogDeAlunoMatriculadoOuvinte extends Ouvinte {

    @Override
    public void reageAo(Evento evento){
        AlunoMatriculadoEvento alunoMatriculadoEvento = (AlunoMatriculadoEvento) evento;
        String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.printf("Aluno de CPF %s cadastrado em %s%n", alunoMatriculadoEvento.getCpfDoAluno(), momentoFormatado);
    }


    @Override
    public boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculadoEvento;
    }
}
