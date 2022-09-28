package br.com.alura.escola.dominio.aluno;

/**
 * Value Object
 */
public class CPF {

    private String numeroCpf;

    public CPF(String numeroCpf){
        if(numeroCpf == null || !isValid(numeroCpf)){
            throw new IllegalArgumentException("CPF invalido");
        }
        this.numeroCpf = numeroCpf;
    }

    private boolean isValid(String numeroCpf){
        return numeroCpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}");
    }


    public String getNumeroCpf() {
        return numeroCpf;
    }

    @Override
    public String toString() {
        return numeroCpf.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CPF cpf = (CPF) o;

        return numeroCpf != null ? numeroCpf.equals(cpf.numeroCpf) : cpf.numeroCpf == null;
    }

    @Override
    public int hashCode() {
        return numeroCpf != null ? numeroCpf.hashCode() : 0;
    }
}
