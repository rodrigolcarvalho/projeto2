package br.com.bb.java.main.services;

import java.util.HashMap;
import java.util.Map;

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
    public Mercadoria getMercadoriaPorId(int id) throws BuscaMercadoriaExcecao{
        try {
            return mercadorias.get(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void adicionarItem(Produto produto, int quantidade) {
        int qtdAnterior = 0;
        try {
            qtdAnterior = mercadorias.get(produto.getCodigo()).getQuantidade();
        } catch (Exception e) {

        }
        if(qtdAnterior > 0) {
            mercadorias.put(produto.getCodigo(), new Mercadoria(produto, quantidade + qtdAnterior));
        }
        else {
            mercadorias.put(produto.getCodigo(), new Mercadoria(produto, quantidade));
        }
    }

    public void retirarItem(Produto produto, int quantidade) throws BuscaMercadoriaExcecao {
        int qtdAnterior = 0;
        try {
            qtdAnterior = mercadorias.get(produto.getCodigo()).getQuantidade();
        } catch (Exception e) {
            System.out.println("Produto não encontrado");
            throw e;
        }
        if(qtdAnterior - quantidade > 0) {
            mercadorias.put(produto.getCodigo(), new Mercadoria(produto, qtdAnterior - quantidade));
        }
        else {
            mercadorias.remove(produto.getCodigo());
        }
    }
    public Double getPrecoTotal () {
        Double precoTotal = 0.0;
        for (Map.Entry<Integer, Mercadoria> it : mercadorias.entrySet()) {
            precoTotal += it.getValue().getPrecoTotal();
        }
        return precoTotal;
    }

    @Override
    public String toString() {
        return 
            "carrinho='\n" + getMercadorias().toString() + "'";
    }
        
        
}
