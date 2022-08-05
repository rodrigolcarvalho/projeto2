package br.com.bb.projeto2;

import br.com.bb.projeto2.dao.ProdutoDao;
import br.com.bb.projeto2.models.Cliente;
import br.com.bb.projeto2.models.clientes.PessoaFisica;
import br.com.bb.projeto2.models.Produto;
import br.com.bb.projeto2.services.Carrinho;
import br.com.bb.projeto2.util.JPAUtil;

import javax.persistence.EntityManager;


public class App {

    private static final EntityManager em = JPAUtil.getEntityManager();

    public static void main(String[] args) throws Exception {
        Produto camiseta = new Produto(1, "camiseta", 120.0);
        Produto bermuda = new Produto(2, "bermuda", 50.0);
        Produto blusa = new Produto(3, "blusa", 150.0, true);

        ProdutoDao produtoDao = new ProdutoDao(em);

        try {
            em.getTransaction().begin();
            produtoDao.salvar(camiseta);
            produtoDao.salvar(bermuda);
            produtoDao.salvar(blusa);
            System.out.println("Lista de produtos disponíveis: " + produtoDao.buscarTodos());

            Carrinho carrinho = new Carrinho();

            carrinho.adicionarItem(camiseta, 20);
            carrinho.adicionarItem(bermuda, 10);
            carrinho.adicionarItem(blusa, 30);
            System.out.println(carrinho);

            System.out.println("Adicionar mais 2 blusas");
            carrinho.adicionarItem(blusa, 2);
            System.out.println(carrinho);

            //System.out.println("Retirar 1 bermuda");
            //carrinho.retirarItem(bermuda, 1);
            //System.out.println(carrinho);

            // System.out.println("Retirar 4 blusas");
            //carrinho.retirarItem(blusa, 4);
            //System.out.println(carrinho);
            System.out.println("Total a pagar: R$" + carrinho.getPrecoTotal());
            System.out.println("Total Taxa extra Importação: R$" + carrinho.getTaxaExtra());
            System.out.println("Total Valor do Frete: R$" + carrinho.getFrete());

            Cliente cliente = new PessoaFisica("017", "nome");
            cliente.addCarrinho(carrinho);

            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            em.getTransaction().rollback();
        }

    }
}
