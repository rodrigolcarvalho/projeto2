package br.com.bb.java.main.models;

import java.util.ArrayList;
import java.util.List;

import br.com.bb.java.main.services.Carrinho;

public class Cliente {
    private final String id;
    private String nome;
    private final List<Carrinho> carrinhos;


    public Cliente(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.carrinhos = new ArrayList<>();
    }
    public Cliente(String id, String nome, Carrinho carrinho) {
        this.id = id;
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
    

    public String getId() {
        return this.id;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", carrinhos='" + getCarrinhos() + "'" +
            "}";
    }


}
