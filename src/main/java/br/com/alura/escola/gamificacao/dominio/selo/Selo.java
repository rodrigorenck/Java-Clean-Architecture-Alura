package br.com.alura.escola.gamificacao.dominio.selo;

import br.com.alura.escola.shared.dominio.CPF;

/**
 * Representa tipo uma medalha no contexto de gamificacao da Alura
 */
public class Selo {

    private CPF cpfDoAluno;
    private String nome;

    public Selo(CPF cpfDoAluno, String nome) {
        this.cpfDoAluno = cpfDoAluno;
        this.nome = nome;
    }

    public CPF getCpfDoAluno() {
        return cpfDoAluno;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Selo selo = (Selo) o;

        return nome != null ? nome.equals(selo.nome) : selo.nome == null;
    }

    @Override
    public int hashCode() {
        return nome != null ? nome.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Selo{" +
                "cpfDoAluno=" + cpfDoAluno +
                ", nome='" + nome + '\'' +
                '}';
    }
}
