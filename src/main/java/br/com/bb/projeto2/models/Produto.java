package br.com.bb.projeto2.models;

import lombok.*;

import javax.persistence.*;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private final String nome;
    private final Double preco;
    private boolean importado;
    private TipoCategoria categoria;

//    public Produto(String nome, Double preco) {
//        this.nome = nome;
//        this.preco = preco;
//        this.importado = false;
//        this.categoria = TipoCategoria.NAO_LISTADO;
//    }
//
//    public Produto(String nome, Double preco, boolean importado) {
//        this(nome, preco);
//        this.importado = importado;
//    }
//
//    public Produto(String nome, Double preco, boolean importado, TipoCategoria categoria) {
//        this(nome, preco, importado);
//        this.categoria = categoria;
//    }

}
