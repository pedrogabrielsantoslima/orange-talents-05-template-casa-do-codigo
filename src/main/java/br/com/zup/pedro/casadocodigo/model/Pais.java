package br.com.zup.pedro.casadocodigo.model;

import javax.persistence.*;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Deprecated
    public Pais(){}

    public Pais(Integer id){
        this.id = id;
    }

    public Pais(String nome){
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
