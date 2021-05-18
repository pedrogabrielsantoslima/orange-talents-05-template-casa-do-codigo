package br.com.zup.pedro.casadocodigo.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, length = 400)
    private String descricao;
    @Column(nullable = false)
    private final LocalDateTime instante = LocalDateTime.now();

    @Deprecated
    public Autor(){}

    public Autor(String nome, String email, String descricao){
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getInstante() {
        return instante;
    }
}
