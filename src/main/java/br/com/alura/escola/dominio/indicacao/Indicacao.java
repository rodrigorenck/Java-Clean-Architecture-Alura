package br.com.alura.escola.dominio.indicacao;

import br.com.alura.escola.dominio.aluno.Aluno;

import java.time.LocalDateTime;

public class Indicacao {

    private Aluno indicado;
    private Aluno indicador;
    private LocalDateTime dataIndicacao;

    public Indicacao(Aluno indicado, Aluno indicador) {
        this.indicado = indicado;
        this.indicador = indicador;
        dataIndicacao = LocalDateTime.now();
    }

    public Aluno getIndicado() {
        return indicado;
    }

    public Aluno getIndicador() {
        return indicador;
    }

    public LocalDateTime getDataIndicacao() {
        return dataIndicacao;
    }
}
