package br.com.zup.pedro.casadocodigo.response;

import br.com.zup.pedro.casadocodigo.model.Livro;
import br.com.zup.pedro.casadocodigo.request.LivroRequest;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroResponse extends LivroRequest {

    private Integer id;
    private String sumario;

    public LivroResponse(String titulo, String resumo, BigDecimal preco, Integer paginas,
                         String isbn, LocalDate dataPublicacao, Integer idAutor, Integer idCategoria) {

        super(titulo, resumo, preco, paginas, isbn, dataPublicacao, idAutor, idCategoria);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public static LivroResponse converterDe(Livro livro) {
        final LivroResponse livroResponse = new LivroResponse(livro.getTitulo(), livro.getResumo(), livro.getPreco(),
                livro.getPaginas(), livro.getIsbn(), livro.getDataPublicacao(), livro.getAutor().getId(), livro.getCategoria().getId());

        livroResponse.id = livro.getId();
        livroResponse.sumario = livro.getSumario();

        return livroResponse;
    }
}
