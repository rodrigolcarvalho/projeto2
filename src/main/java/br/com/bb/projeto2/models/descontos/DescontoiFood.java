package br.com.bb.projeto2.models.descontos;

import br.com.bb.projeto2.models.Mercadoria;
import br.com.bb.projeto2.models.Produto;
import br.com.bb.projeto2.models.TipoCategoria;

import java.util.Collection;

public class DescontoiFood implements Desconto {

    private final int QUANTIDADE_MINIMA = 10;
    private final Double porcentagemDesconto;

    public DescontoiFood(Double porcentagemDesconto) {
        this.porcentagemDesconto = porcentagemDesconto;
    }
    @Override
    public Double calcularDesconto(Collection<Mercadoria> listaMercadorias) {
        double desconto = 0.0;
        for (Mercadoria mercadoria: listaMercadorias) {
            Produto produto = mercadoria.getProduto();
            if (produto.getCategoria().equals(TipoCategoria.ALIMENTICIO) && mercadoria.getQuantidade() >= QUANTIDADE_MINIMA) {
                // Não se multiplica pela quantidade, porque é iFood
                desconto += mercadoria.getProduto().getPreco() * porcentagemDesconto;
            }
        }
        return desconto;
    }
}
