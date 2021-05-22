package br.com.zup.pedro.casadocodigo.response;

import br.com.zup.pedro.casadocodigo.model.Categoria;
import br.com.zup.pedro.casadocodigo.request.CategoriaRequest;

public class CategoriaResponse extends CategoriaRequest {

    private static final long serialVersionUID = -2211688689770193898L;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public CategoriaResponse(final String nome) {
        super(nome);
    }

    public static CategoriaResponse converterDe(Categoria categoria) {
        final CategoriaResponse categoriaResponse = new CategoriaResponse(categoria.getNome());

        categoriaResponse.id = categoria.getId();

        return categoriaResponse;
    }
}
