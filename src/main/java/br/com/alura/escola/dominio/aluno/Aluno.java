package br.com.alura.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

/**
 * Devemos deixar a camada de dominio o mais proximo do mundo real
 * Nao devemos ter atributos que nao estejam nas regras de negocio
 * Devemos isolar completamente da infra
 * Nosso Identificador Unico sera o CPF e nao o ID - entidade
 */
public class Aluno {

//  private Long id; -> detalhe de infra
    private CPF cpf;
    private String nome;
    private Email email;
    private List<Telefone> telefones = new ArrayList<>();
    private String senha;

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public Aluno(){}

    public void adicionarTelefone(String ddd, String numero){
        telefones.add(new Telefone(ddd, numero));
    }

    public String getCpf() {
        return cpf.getNumeroCpf();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEndereco();
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ", email=" + email +
                ", telefones=" + telefones +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aluno aluno = (Aluno) o;

        return cpf != null ? cpf.equals(aluno.cpf) : aluno.cpf == null;
    }

    @Override
    public int hashCode() {
        return cpf != null ? cpf.hashCode() : 0;
    }
}
