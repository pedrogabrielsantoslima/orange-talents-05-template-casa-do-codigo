package br.com.zup.pedro.casadocodigo.request;

import br.com.zup.pedro.casadocodigo.model.Autor;
import br.com.zup.pedro.casadocodigo.model.Categoria;
import br.com.zup.pedro.casadocodigo.model.Livro;
import br.com.zup.pedro.casadocodigo.validator.ExistsId;
import br.com.zup.pedro.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank(message = "O titulo é obrigatório")
    @Length(min = 3, max = 255, message = "O titulo deverá ter entre {min} e {max} caracteres")
    @UniqueValue(fieldName = "titulo", model = Livro.class)
    private String titulo;

    @NotBlank(message = "O resumo é obrigatório")
    @Length(min = 3, max = 500, message = "O resumo deverá ter entre {min} e {max} caracteres")
    private String resumo;

    @NotNull(message = "O preço é obrigatório")
    @Length(min = 20, message = "O preço deve ser R${min} no minimo")
    private BigDecimal preco;

    @NotNull(message = "Numero de paginas obrigatório")
    @Length(min = 100, message = "O livro deverá ter {min} paginas no minimo")
    private Integer paginas;

    @NotBlank(message = "ISBN é obrigatório")
    @UniqueValue(fieldName = "isbn", model = Livro.class)
    private String isbn;

    @NotNull(message = "Data é obrigatório")
    @Future @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull(message = "O Autor é obrigatório")
    @ExistsId(fieldName = "id", model = Autor.class)
    private Integer idAutor;

    @NotNull(message = "A Categoria é obrigatório")
    @ExistsId(fieldName = "id", model = Categoria.class)
    private Integer idCategoria;

    public LivroRequest(String titulo, String resumo, BigDecimal preco, Integer paginas,
                        String isbn, LocalDate dataPublicacao, Integer idAutor, Integer idCategoria){

        this.titulo = titulo;
        this.resumo = resumo;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idAutor = idAutor;
        this.idCategoria = idCategoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
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

    public Integer getIdAutor() {
        return idAutor;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public Livro toModel(EntityManager manager) {

        Autor autor = manager.find(Autor.class, idAutor);
        Categoria categoria = manager.find(Categoria.class, idCategoria);

        return new Livro(titulo, resumo, preco, paginas, isbn, dataPublicacao, autor, categoria);
    }
}
