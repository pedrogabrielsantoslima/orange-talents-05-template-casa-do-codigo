package br.com.zup.pedro.casadocodigo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String titulo;
    @Column(nullable = false, length = 500)
    private String resumo;
    @Column
    private String sumario;
    @Column(nullable = false)
    private BigDecimal preco = new BigDecimal(0.1);
    @Column(nullable = false)
    private Integer paginas;
    @Column(nullable = false, unique = true)
    private String isbn;
    @Column(nullable = false)
    private LocalDate dataPublicacao;
    @ManyToOne
    private Autor autor;
    @ManyToOne
    private Categoria categoria;

    @Deprecated
    public Livro(){}

    public Livro(String titulo, String resumo, BigDecimal preco, Integer paginas, String isbn,
                 LocalDate dataPublicacao, Autor autor, Categoria categoria) {

        this.titulo = titulo;
        this.resumo = resumo;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
