package br.com.bb.projeto2.services;

import br.com.bb.projeto2.exceptions.BuscaMercadoriaExcecao;
import br.com.bb.projeto2.models.Mercadoria;
import br.com.bb.projeto2.models.Produto;

import java.util.HashMap;


public class Carrinho {
    private final Double TAXA_FRETE = 0.05;
    private final Double TAXA_IMPORACAO = 0.60;
    private final Double PRECO_FRETE_GRATIS = 149.99;
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
    /*
     * public Double getFrete(){
     * Double frete = 0.0;
     * if(getPrecoTotal() >= PRECO_FRETE_GRATIS ){
     * frete = getPrecoTotal() * TAXA_FRETE;
     * }
     * 
     * return frete;
     * }
     */

    public Double getFrete() {
        Double frete = 0.0;
        for (Mercadoria mercadoria : mercadorias.values()) {
            // cobrança de frete ( porcentagem) para produtos com valor menor que 149.99,
            // acima n eh cobrado frete
            if (mercadoria.getProduto().getPreco() <= PRECO_FRETE_GRATIS) {
                frete = frete + (mercadoria.getProduto().getPreco() * TAXA_FRETE);
            }
        }
        return frete;
    }

    public Double getTaxaExtra() {
        Double taxaExtra = 0d;
        for (Mercadoria mercadoria : mercadorias.values()) {
            Produto produto = mercadoria.getProduto();
            // Cobrança de taxa extra (porcentagem) para produtos importados, produtos não
            // importados sem taxa
            if (produto.isImportado()) {
                taxaExtra += (produto.getPreco() * TAXA_IMPORACAO);
            }
        }
        return taxaExtra;
    }

    @Override
    public String toString() {
        return "carrinho='\n" + getMercadorias().toString() + "'";
    }

}
