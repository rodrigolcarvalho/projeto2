package br.com.bb.java.main.models;

public class Pedido {
    private Produto produto;
    private int quantidade;
    private Double precoTotal;

    public Pedido(Produto produto, int quantidade) {
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
    
}
