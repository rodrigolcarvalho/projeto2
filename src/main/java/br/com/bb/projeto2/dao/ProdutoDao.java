package br.com.bb.projeto2.dao;
import java.util.List;

import br.com.bb.projeto2.models.Produto;

import javax.persistence.EntityManager;

public class ProdutoDao {
    private final EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void adicionar(Produto produto) {
        this.em.getTransaction().begin();

        this.em.persist(produto);
        System.out.println("Produto salvo " + produto);

        this.em.getTransaction().commit();
    }

    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM Produto p";
        return this.em.createQuery(jpql, Produto.class).getResultList();
    }

    public void remover(Produto produto) {
        this.em.getTransaction().begin();

        produto = this.em.merge(produto); // garante que o objeto está managed
        this.em.remove(produto);
        System.out.println("Produto removido " + produto);

        this.em.getTransaction().commit();
    }

    public Produto buscaPorId(Integer id) {
        return this.em.find(Produto.class, id);
    }

    public Produto buscaPorNome(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE nome = :nome";
        return this.em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }


}
