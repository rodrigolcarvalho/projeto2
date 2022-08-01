package br.com.bb.java.main.models;

public class Cliente {
    private final String id;
    private String nome;


    public Cliente(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    

    public String getId() {
        return this.id;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            "}";
    }

}
