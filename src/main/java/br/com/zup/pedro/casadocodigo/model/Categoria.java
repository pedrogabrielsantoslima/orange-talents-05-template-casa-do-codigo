package br.com.zup.pedro.casadocodigo.model;

import javax.persistence.*;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Deprecated
    public Categoria(){}

    public Categoria(Integer id){
        this.id = id;
    }

    public Categoria(String nome){
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
