package br.com.bb.projeto2.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    private int codigo;
    private String nome;
    private Double preco;
    private boolean importado;

    public Produto(int codigo, String nome, Double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.importado = false;
    }

    public Produto(int codigo, String nome, Double preco, boolean importado) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.importado = importado;
    }

    public boolean isImportado() {
        return this.importado;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "{" +
                " codigo='" + getCodigo() + "'" +
                ", nome='" + getNome() + "'" +
                ", preco='" + getPreco() + "'" +
                "}";
    }

}
