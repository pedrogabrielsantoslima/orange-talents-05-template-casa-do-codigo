package br.com.zup.pedro.casadocodigo.model;

import javax.persistence.*;

@Entity
public class Estados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String nome;
    @ManyToOne
    private Pais pais;

    @Deprecated
    public Estados(){}

    public Estados(Integer id){
        this.id = id;
    }

    public Estados(String nome, Pais pais){

        this.nome = nome;
        this.pais = pais;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }
}
