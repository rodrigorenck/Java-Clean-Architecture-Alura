package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.AlunoBuilder;

/**
 * Classe que vai guardar os dados do aluno quando for enviado por um client externo
 */
public class MatricularAlunoDto {

    private String cpf;
    private String nome;
    private String enderecoEmail;
    private String ddd;
    private String numero;

    public MatricularAlunoDto(String cpf, String nome, String enderecoEmail, String ddd, String numero) {
        this.cpf = cpf;
        this.nome = nome;
        this.enderecoEmail = enderecoEmail;
        this.ddd = ddd;
        this.numero = numero;
    }

    public Aluno criarAluno(){
        return AlunoBuilder.builder()
                .comNome(nome)
                .comEmail(enderecoEmail)
                .comCpf(cpf)
                .comTelefone(ddd, numero)
                .build();
    }
}
