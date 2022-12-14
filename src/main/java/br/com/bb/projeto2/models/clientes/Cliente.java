package br.com.bb.projeto2.models.clientes;


import br.com.bb.projeto2.services.Carrinho;

import java.util.ArrayList;
import java.util.List;



public abstract class Cliente {
    private String nome;
    private final List<Carrinho> carrinhos;


    public Cliente(String nome) {
        this.nome = nome;
        this.carrinhos = new ArrayList<>();
    }
    public Cliente(String nome, Carrinho carrinho) {
        this.nome = nome;
        this.carrinhos = new ArrayList<>();
        this.carrinhos.add(carrinho);
    }

    public List<Carrinho> getCarrinhos() {
        return carrinhos;
    }
    public void addCarrinho(Carrinho carrinho) {
        this.carrinhos.add(carrinho);
    }
    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract String getId();

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", carrinhos='" + getCarrinhos() + "'" +
            "}";
    }
}
