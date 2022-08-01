package br.com.bb.java.main;

import br.com.bb.java.main.models.Produto;
import br.com.bb.java.main.services.Carrinho;

public class App {
    public static void main(String[] args) throws Exception {
        Produto camiseta = new Produto(1, "camiseta", 120.0);
        Produto bermuda = new Produto(2, "bermuda", 50.0);
        Produto blusa = new Produto(3, "blusa", 150.0);

        Carrinho carrinho = new Carrinho();

        carrinho.adicionarItem(camiseta, 2);
        carrinho.adicionarItem(bermuda, 1);
        carrinho.adicionarItem(blusa, 3);

        carrinho.adicionarItem(blusa, 2);

        System.out.println(carrinho);
    }
}
