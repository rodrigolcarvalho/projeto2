package br.com.bb.java.main;

import br.com.bb.java.main.dao.ProdutoDao;
import br.com.bb.java.main.models.Cliente;
import br.com.bb.java.main.models.PessoaFisica;
import br.com.bb.java.main.models.Produto;
import br.com.bb.java.main.services.Carrinho;

public class App {
    public static void main(String[] args) throws Exception {
        Produto camiseta = new Produto(1, "camiseta", 120.0);
        Produto bermuda = new Produto(2, "bermuda", 50.0);
        Produto blusa = new Produto(3, "blusa", 150.0);

        ProdutoDao produtos = new ProdutoDao();
        produtos.salvar(camiseta);
        produtos.salvar(bermuda);
        produtos.salvar(blusa);
        System.out.println("Lista de produtos disponíveis: " + produtos.buscarTodos());
        
        Carrinho carrinho = new Carrinho();

        carrinho.adicionarItem(camiseta, 20);
        carrinho.adicionarItem(bermuda, 10);
        carrinho.adicionarItem(blusa, 30);
        System.out.println(carrinho);

        System.out.println("Adicionar mais 2 blusas");
        carrinho.adicionarItem(blusa, 2);
        System.out.println(carrinho);
        
        System.out.println("Retirar 1 bermuda");
        carrinho.retirarItem(bermuda, 1);
        System.out.println(carrinho);
        
        System.out.println("Retirar 4 blusas");
        carrinho.retirarItem(blusa, 4);
        System.out.println(carrinho);
        System.out.println("Total a pagar: R$" + carrinho.getPrecoTotal());

        Cliente cliente = new PessoaFisica("017", "nome");
        cliente.addCarrinho(carrinho);


    }
}
