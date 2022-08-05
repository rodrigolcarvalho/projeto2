package br.com.bb.projeto2.models;

import lombok.AllArgsConstructor;

public class Mercadoria {
    private Produto produto;
    private int quantidade;
    private Double precoTotal;

    public Mercadoria(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoTotal = produto.getPreco() * this.quantidade;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        this.precoTotal = this.produto.getPreco()*this.quantidade;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.precoTotal = this.produto.getPreco()*this.quantidade;
    }

    public Double getPrecoTotal() {
        return this.precoTotal;
    }

    @Override
    public String toString() {
        return "" +
            " produto:'" + getProduto() + "'" +
            ", quantidade:'" + getQuantidade() + "'" +
            ", precoTotal: 'R$" + getPrecoTotal() + "'" +
            "\n";
    }
}
