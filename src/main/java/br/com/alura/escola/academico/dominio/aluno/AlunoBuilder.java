package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.CPF;

/**
 * Design Pattern Builder
 */
public class AlunoBuilder {

    private Aluno aluno = new Aluno();

    public static AlunoBuilder builder() {
        return new AlunoBuilder();
    }

    public Aluno build() {
        return aluno;
    }

    public AlunoBuilder comNome(String nome) {
        aluno.setNome(nome);
        return this;
    }

    public AlunoBuilder comCpf(String cpf) {
        aluno.setCpf(new CPF(cpf));
        return this;
    }

    public AlunoBuilder comEmail(String email) {
        aluno.setEmail(new Email(email));
        return this;
    }

    public AlunoBuilder comTelefone(String ddd, String numero) {
        aluno.adicionarTelefone(ddd, numero);
        return this;
    }
}
