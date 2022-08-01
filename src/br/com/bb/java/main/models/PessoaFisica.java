package br.com.bb.java.main.models;

public class PessoaFisica extends Cliente{
    private final String cpf;

    public PessoaFisica(String id, String nome) {
        super(nome);
        this.cpf = id;
    }

    @Override
    public String getId() {
        return cpf;
    }
    
}
