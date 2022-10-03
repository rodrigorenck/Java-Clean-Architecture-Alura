package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.dominio.evento.TipoEvento;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Evento
 */
public class AlunoMatriculadoEvento implements Evento {

    private final LocalDateTime momento;
    private final CPF cpfDoAluno;

    public AlunoMatriculadoEvento(CPF cpf){
        this.cpfDoAluno = cpf;
        this.momento = LocalDateTime.now();
    }

    @Override
    public LocalDateTime momento() {
        return momento;
    }

    @Override
    public TipoEvento evento() {
        return TipoEvento.ALUNO_MATRICULADO;
    }

    @Override
    public Map<String, Object> informacoes() {
        return Map.of("cpf", cpfDoAluno);
    }

    public CPF getCpfDoAluno() {
        return cpfDoAluno;
    }
}
