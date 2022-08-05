package br.com.bb.projeto2.models.descontos;

import br.com.bb.projeto2.models.Mercadoria;

import java.util.Collection;
import java.util.List;

public interface Desconto {

    Double calcularDesconto(Collection<Mercadoria> listaProdutos);
}
