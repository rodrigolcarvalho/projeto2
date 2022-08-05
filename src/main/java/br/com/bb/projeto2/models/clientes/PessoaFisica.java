package br.com.bb.projeto2.models.clientes;

import br.com.bb.projeto2.models.clientes.Cliente;

public class PessoaFisica extends Cliente {
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
