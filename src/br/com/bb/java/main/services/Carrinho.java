package br.com.bb.java.main.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.bb.java.main.models.Pedido;

public class Carrinho {
    private final HashMap<Integer, Pedido> pedidos;

    public Carrinho() {
        this.pedidos = new HashMap<Integer, Pedido>();
    }

    public HashMap<Integer, Pedido> itens() {
        return pedidos;
    }
    
    public void adicionarItem(Integer id, Pedido pedido) {
        pedidos.put(id, pedido);
    }
}
