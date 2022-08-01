package br.com.bb.java.main.models;

public class PessoaFisica extends Cliente{
    private final String cpf;

    public PessoaFisica(String id, String nome) {
        super(id, nome);
        this.cpf = id;
    }

    public String getCpf() {
        return cpf;
    }
    
}
