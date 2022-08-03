package br.com.bb.java.main.models;

public class PessoaJuridica extends Cliente{
    private final String cnpj;

    public PessoaJuridica(String id, String nome) {
        super(nome);
        this.cnpj = id;
    }

    @Override
    public String getId() {
        return cnpj;        
    }
}
