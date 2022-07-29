package br.com.bb.java.main.services;

import java.util.ArrayList;
import java.util.List;

import br.com.bb.java.main.models.Pedido;

public class Carrinho {
    private final List<Pedido> pedidos;

    public Carrinho() {
        this.pedidos = new ArrayList<>();
    }

    public List<Pedido> itens() {
        return pedidos;
    }
    
}
