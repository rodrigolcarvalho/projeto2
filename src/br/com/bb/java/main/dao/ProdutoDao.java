package br.com.bb.java.main.dao;
import java.util.ArrayList;
import java.util.List;
import br.com.bb.java.main.models.Produto;

public class ProdutoDao {
    private static List<Produto> produtos = new ArrayList<>();

    public void salvar(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto salvo " + produto);
    }

    public List<Produto> buscarTodos() {
        return produtos;
    }

    public void remover(Produto produto) {
        produtos.remove(produto);
        System.out.println("Produto removido " + produto);
    }

    public Produto buscaPorId(String o) {
        return null;
    }

}
