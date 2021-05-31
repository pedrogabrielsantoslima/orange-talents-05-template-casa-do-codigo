package br.com.zup.pedro.casadocodigo.model;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String cpf_cnpj;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String complemento;
    @Column(nullable = false)
    private String cidade;
    @ManyToOne
    private Pais pais;
    @ManyToOne
    private Estados estados;
    @Column(nullable = false)
    private Integer telefone;
    @Column(nullable = false)
    private Integer cep;

    @Deprecated
    public Cliente(){}

    public Cliente(String nome, String sobrenome, String email, String cpf_cnpj, String endereco,
                   String complemento, String cidade, Pais pais, Estados estados, Integer telefone, Integer cep){

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf_cnpj = cpf_cnpj;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estados = estados;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public Estados getEstados() {
        return estados;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public Integer getCep() {
        return cep;
    }
}
