package br.com.alura.escola.academico.dominio.aluno;

/**
 * Value Object
 */
public class Telefone {

    private String ddd; //2 digitos
    private String numero; // 8 ou 9 digitos

    public Telefone(String ddd, String numero) {
        //validacao
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return ddd + " " + numero;
    }
}
