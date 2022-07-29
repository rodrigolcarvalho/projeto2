package br.com.bb.java.main.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.bb.java.main.models.Mercadoria;

public class Carrinho {
    private final HashMap<Integer, Mercadoria> pedidos;

    public Carrinho() {
        this.pedidos = new HashMap<Integer, Mercadoria>();
    }

    public HashMap<Integer, Mercadoria> itens() {
        return pedidos;
    }
    
    public void adicionarItem(Integer id, Mercadoria pedido) {
        pedidos.put(id, pedido);
    }
}
