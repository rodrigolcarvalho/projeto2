package br.com.bb.projeto2.exceptions;

public class BuscaMercadoriaExcecao extends RuntimeException{
    public BuscaMercadoriaExcecao(TipoMercadoriaExcecao tipo) {
        super(tipo.getErro());
    }
    
}
