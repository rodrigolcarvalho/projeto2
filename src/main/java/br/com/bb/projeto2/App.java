package br.com.bb.projeto2;

import br.com.bb.projeto2.dao.ProdutoDao;
import br.com.bb.projeto2.models.Mercadoria;
import br.com.bb.projeto2.models.TipoCategoria;
import br.com.bb.projeto2.models.clientes.Cliente;
import br.com.bb.projeto2.models.clientes.PessoaFisica;
import br.com.bb.projeto2.models.Produto;
import br.com.bb.projeto2.models.descontos.Desconto;
import br.com.bb.projeto2.models.descontos.DescontoiFood;
import br.com.bb.projeto2.services.Carrinho;
import br.com.bb.projeto2.util.JPAUtil;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class App {

    private static final double porcentagemDesconto = 3.0 / 100.0;

    private static final EntityManager em = JPAUtil.getEntityManager();

    public static void main(String[] args) throws Exception {
        Carrinho carrinho = new Carrinho();
        ProdutoDao produtoDao = new ProdutoDao(JPAUtil.getEntityManager());
        load(produtoDao);

        try {
            carrinho.adicionarItem(produtoDao.buscaPorNome("camiseta"), 20);
            carrinho.adicionarItem(produtoDao.buscaPorNome("bermuda"), 10);
            carrinho.adicionarItem(produtoDao.buscaPorNome("blusa"), 30);

            System.out.println("Adicionar mais 2 blusas");
            carrinho.adicionarItem(produtoDao.buscaPorNome("blusa"), 2);

            System.out.println("Retirar 1 bermuda");
            carrinho.retirarItem(produtoDao.buscaPorNome("bermuda"), 1);

             System.out.println("Retirar 31 blusas");
            carrinho.retirarItem(produtoDao.buscaPorNome("blusa"), 31);

            carrinho.aplicarDesconto(new DescontoiFood(porcentagemDesconto));

            Desconto fazNaRoupa = lista ->
            {
                double desconto = 0.0;
                for (Mercadoria mercadoria: lista) {
                    Produto produto = mercadoria.getProduto();
                    if (produto.getCategoria().equals(TipoCategoria.ROUPA)) {
                        desconto += mercadoria.getProduto().getPreco() * porcentagemDesconto;
                    }
                }
                return desconto;
            };

            carrinho.aplicarDesconto(fazNaRoupa);

            carrinho.adicionarItem(produtoDao.buscaPorNome("sushi"), 30);
            System.out.println(carrinho);

            System.out.println("Total Taxa extra Importa????o: R$" + carrinho.getTaxaExtra());
            System.out.println("Total Valor do Frete: R$" + carrinho.getFrete());
            System.out.println("Total Valor do Desconto: R$" + carrinho.getDesconto());
            System.out.println("Total a pagar R$" + carrinho.getPrecoTotal());


            Cliente cliente = new PessoaFisica("013", "Roger");
            cliente.addCarrinho(carrinho);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            em.getTransaction().rollback();
        }

    }

    public static void load(ProdutoDao produtoDao) {
        Produto sushi = Produto.builder()
                .categoria(TipoCategoria.ALIMENTICIO)
                .nome("sushi")
                .preco(4.0)
                .importado(true)
                .build();

        Produto camiseta = Produto.builder()
                .categoria(TipoCategoria.ROUPA)
                .nome("camiseta")
                .preco(120.0)
                .build();

        Produto bermuda = Produto.builder()
                .categoria(TipoCategoria.ROUPA)
                .nome("bermuda")
                .preco(50.0)
                .build();

        Produto blusa = Produto.builder()
                .categoria(TipoCategoria.ROUPA)
                .nome("blusa")
                .preco(150.0)
                .importado(true)
                .build();

        produtoDao.adicionar(sushi);
        produtoDao.adicionar(camiseta);
        produtoDao.adicionar(bermuda);
        produtoDao.adicionar(blusa);

        System.out.println("Lista de produtos dispon??veis: " + produtoDao.buscarTodos());
    }
}
