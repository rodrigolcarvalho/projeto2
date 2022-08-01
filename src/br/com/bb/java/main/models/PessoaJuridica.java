package br.com.bb.java.main.models;

public class PessoaJuridica extends Cliente{
    private final String cnpj;

    public PessoaJuridica(String id, String nome) {
        super(id, nome);
        this.cnpj = id;
    }
    
    public String getCnpj() {
        return cnpj;
    }
}
