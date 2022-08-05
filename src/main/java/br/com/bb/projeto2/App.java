package br.com.bb.projeto2;

import br.com.bb.projeto2.dao.ProdutoDao;
import br.com.bb.projeto2.models.clientes.Cliente;
import br.com.bb.projeto2.models.clientes.PessoaFisica;
import br.com.bb.projeto2.models.Produto;
import br.com.bb.projeto2.services.Carrinho;
import br.com.bb.projeto2.util.JPAUtil;

import javax.inject.Inject;
import javax.persistence.EntityManager;


public class App {

    private static final EntityManager em = JPAUtil.getEntityManager();

    private final static Carrinho carrinho =  Carrinho.getInstance();

    public static void main(String[] args) throws Exception {
        ProdutoDao produtoDao = new ProdutoDao(JPAUtil.getEntityManager());
        load(produtoDao);

        try {
            carrinho.adicionarItem(produtoDao.buscaPorNome("camiseta"), 20);
            carrinho.adicionarItem(produtoDao.buscaPorNome("bermuda"), 10);
            carrinho.adicionarItem(produtoDao.buscaPorNome("blusa"), 30);
            System.out.println(carrinho);

            System.out.println("Adicionar mais 2 blusas");
            carrinho.adicionarItem(produtoDao.buscaPorNome("blusa"), 2);
            System.out.println(carrinho);

            System.out.println("Retirar 1 bermuda");
            carrinho.retirarItem(produtoDao.buscaPorNome("bermuda"), 1);
            System.out.println(carrinho);

             System.out.println("Retirar 31 blusas");
            carrinho.retirarItem(produtoDao.buscaPorNome("blusa"), 31);
            System.out.println(carrinho);

            System.out.println("Total Taxa extra Importação: R$" + carrinho.getTaxaExtra());
            System.out.println("Total Valor do Frete: R$" + carrinho.getFrete());
            System.out.println("Total a pagar R$" + carrinho.getPrecoTotal());

            Cliente cliente = new PessoaFisica("013", "Roger");
            cliente.addCarrinho(carrinho);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            em.getTransaction().rollback();
        }

    }

    private static void load(ProdutoDao produtoDao) {
        Produto camiseta = new Produto(1, "camiseta", 120.0);
        Produto bermuda = new Produto(2, "bermuda", 50.0);
        Produto blusa = new Produto(3, "blusa", 150.0, true);

        produtoDao.adicionar(camiseta);
        produtoDao.adicionar(bermuda);
        produtoDao.adicionar(blusa);
        System.out.println("Lista de produtos disponíveis: " + produtoDao.buscarTodos());
    }
}
