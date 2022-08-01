package br.com.bb.java.main.services;

import java.util.HashMap;

import br.com.bb.java.main.models.Mercadoria;
import br.com.bb.java.main.models.Produto;

public class Carrinho {
    private final HashMap<Integer, Mercadoria> mercadorias;

    public Carrinho() {
        this.mercadorias = new HashMap<Integer, Mercadoria>();
    }

    public HashMap<Integer, Mercadoria> getMercadorias() {
        return mercadorias;
    }
    
    public void adicionarItem(Produto produto, int quantidade) {
        mercadorias.put(produto.getCodigo(), new Mercadoria(produto, quantidade));
    }

    @Override
    public String toString() {
        return 
            "mercadorias='\n" + getMercadorias().toString() + "'"
            ;
        }
        
        
}
