package br.com.bb.java.main.services;

import java.util.HashMap;

import br.com.bb.java.main.exceptions.BuscaMercadoriaExcecao;
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

    public Mercadoria getMercadoriaPorId(int id) throws BuscaMercadoriaExcecao {
        try {
            return mercadorias.get(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (this.mercadorias.containsKey(produto.getCodigo())) {
            quantidade += this.mercadorias.get(produto.getCodigo()).getQuantidade();
        }

        mercadorias.put(produto.getCodigo(), new Mercadoria(produto, quantidade));
    }

    public void retirarItem(Produto produto, int quantidade) {
        if (this.mercadorias.containsKey(produto.getCodigo())) {
            quantidade -= this.mercadorias.get(produto.getCodigo()).getQuantidade();
        } else {
            System.out.println("Produto não encontrado");
            return;
        }

        if (quantidade <= 0) {
            this.mercadorias.remove(produto.getCodigo());
        } else {
            mercadorias.put(produto.getCodigo(), new Mercadoria(produto, quantidade));
        }
    }

    public Double getPrecoTotal() {
        Double precoTotal = 0.0;
        for (Mercadoria mercadoria : mercadorias.values()) {
            precoTotal += mercadoria.getPrecoTotal();
        }
        return precoTotal;
    }

    @Override
    public String toString() {
        return "carrinho='\n" + getMercadorias().toString() + "'";
    }

}
