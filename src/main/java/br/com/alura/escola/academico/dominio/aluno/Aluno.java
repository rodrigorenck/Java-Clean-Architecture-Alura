package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.CPF;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Devemos deixar a camada de dominio o mais proximo do mundo real
 * Nao devemos ter atributos que nao estejam nas regras de negocio
 * Devemos isolar completamente da infra
 * Nosso Identificador Unico sera o CPF e nao o ID - entidade
 */
//AGGREGATE ROOT - Entidade composta de Value Objects
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
        //invariante - regra de negocio para garantir a consistencia do objeto
        if(telefones.size()>=2) throw new TelefoneException("Limite de dois numeros de telefone atingido");
        telefones.add(new Telefone(ddd, numero));
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEndereco();
    }

    /**
     * Importante devolvermos uma lista imodificavel pois soh quem deve manipular seu VO eh a AGGREGATE ROOT (classe aluno)
     * Desse modo evitamos inconsistencias
     */
    public List<Telefone> getTelefones() {
        return Collections.unmodifiableList(telefones);
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
