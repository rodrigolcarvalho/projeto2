package br.com.bb.projeto2.exceptions;


public enum TipoMercadoriaExcecao {

    PRODUTO_NAO_ENCONTRADO("Produto não encontrado");

    private final String erro;

    TipoMercadoriaExcecao(String erro) {
        this.erro = erro;
    }

    public String getErro() {
        return erro;
    }
}