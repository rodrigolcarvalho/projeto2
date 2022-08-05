package br.com.bb.projeto2.models.clientes;

import br.com.bb.projeto2.models.Cliente;

public class PessoaJuridica extends Cliente {
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
