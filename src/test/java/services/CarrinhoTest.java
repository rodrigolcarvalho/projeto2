package services;


import br.com.bb.projeto2.App;
import br.com.bb.projeto2.dao.ProdutoDao;
import br.com.bb.projeto2.models.Mercadoria;
import br.com.bb.projeto2.models.Produto;
import br.com.bb.projeto2.services.Carrinho;
import br.com.bb.projeto2.util.JPAUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

public class CarrinhoTest {

    private static final Carrinho carrinho = new Carrinho();
    private static ProdutoDao produtoDao;

    @BeforeAll
    static void inicializar() {
        produtoDao = new ProdutoDao(JPAUtil.getEntityManager());
        App.load(produtoDao);
    }

    @Test
    public void getMercadoriaPorIdSucesso() {
        Mercadoria mercadoria = new Mercadoria(produtoDao.buscaPorNome("sushi"), 33);
        carrinho.adicionarItem(mercadoria.getProduto(), mercadoria.getQuantidade());

        Mercadoria mercadoria2 = carrinho.getMercadoriaPorId(produtoDao.buscaPorNome("sushi").getCodigo());
        Assertions.assertEquals(mercadoria, mercadoria2);
    }

    @Test
    public void getMercadoriaPorIdFalha() {
        Mercadoria mercadoria = new Mercadoria(produtoDao.buscaPorNome("sushi"), 33);
        carrinho.excluirItem(mercadoria.getProduto());

        Mercadoria mercadoria2 = carrinho.getMercadoriaPorId(produtoDao.buscaPorNome("sushi").getCodigo());
        Assertions.assertNull(mercadoria2);
    }

    @Test
    public void getMercadoriaPorNomeSucesso() {
        carrinho.excluirItem(produtoDao.buscaPorNome("sushi"));
        carrinho.getMercadoriaPorId(produtoDao.buscaPorNome("sushi").getCodigo());
    }

    @Test
    public void adicionarItemInexistente() {
        Produto naoExistoDB = Produto.builder()
                .nome("Não Existo no DB")
                .preco(1.0)
                .build();

        carrinho.adicionarItem(naoExistoDB, 10);
    }

    @Test
    public void retirarItemMaisItensSucesso() {
        carrinho.adicionarItem(produtoDao.buscaPorNome("blusa"), 5);
        carrinho.excluirItem(produtoDao.buscaPorNome("blusa"));
    }

    @Test
    public void retirarMaisItensDoQueNoCarrinho() {
        carrinho.adicionarItem(produtoDao.buscaPorNome("blusa"), 5);
        carrinho.retirarItem(produtoDao.buscaPorNome("blusa"), 10);
    }
}