package br.com.bb.java.main.exceptions;

public class BuscaMercadoriaExcecao extends RuntimeException{
    public BuscaMercadoriaExcecao(TipoMercadoriaExcecao tipo) {
        super(tipo.getErro());
    }
    
}
