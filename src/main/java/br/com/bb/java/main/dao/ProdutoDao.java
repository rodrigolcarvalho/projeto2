package br.com.bb.java.main.dao;
import java.util.HashMap;
import java.util.Map;

import br.com.bb.java.main.models.Mercadoria;
import br.com.bb.java.main.models.Produto;
import br.com.bb.java.main.services.Carrinho;

public class ProdutoDao {
    private static HashMap<Integer, Produto> produtos = new HashMap<>();

    public void salvar(Produto produto) {
        produtos.put(produto.getCodigo(), produto);
        System.out.println("Produto salvo " + produto);
    }

    public HashMap<Integer, Produto> buscarTodos() {
        return produtos;
    }

    public void remover(Produto produto) {
        produtos.remove(produto.getCodigo());
        System.out.println("Produto removido " + produto);
    }

    public Produto buscaPorId(Integer o) {
        return produtos.get(o);
    }

    public void salvarProdutosDeUmCarrinho (Carrinho carrinho) {
        for (Map.Entry<Integer, Mercadoria> it : carrinho.getMercadorias().entrySet()) {
           salvar(it.getValue().getProduto());
        }
    }

}
