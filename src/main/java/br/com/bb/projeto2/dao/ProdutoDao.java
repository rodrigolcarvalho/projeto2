package br.com.bb.projeto2.dao;
import java.util.List;
import java.util.Map;

import br.com.bb.projeto2.models.Mercadoria;
import br.com.bb.projeto2.models.Produto;
import br.com.bb.projeto2.services.Carrinho;

import javax.persistence.EntityManager;

public class ProdutoDao {
    private final EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(Produto produto) {
        this.em.persist(produto);
        System.out.println("Produto salvo " + produto);
    }

    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM Produto p";
        return this.em.createQuery(jpql, Produto.class).getResultList();
    }

    public void remover(Produto produto) {
        produto = this.em.merge(produto); // garante que o objeto está managed
        this.em.remove(produto);
        System.out.println("Produto removido " + produto);
    }

    public Produto buscaPorId(Integer o) {
        return this.em.find(Produto.class, o);
    }

    public void salvarProdutosDeUmCarrinho (Carrinho carrinho) {
        for (Map.Entry<Integer, Mercadoria> it : carrinho.getMercadorias().entrySet()) {
           salvar(it.getValue().getProduto());
        }
    }

}
