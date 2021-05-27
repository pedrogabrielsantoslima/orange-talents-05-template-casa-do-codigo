package br.com.zup.pedro.casadocodigo.response;

import br.com.zup.pedro.casadocodigo.model.Pais;
import br.com.zup.pedro.casadocodigo.request.PaisRequest;

public class PaisResponse extends PaisRequest {

    private Integer id;

    public PaisResponse(String nome) {
        super(nome);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static PaisResponse converterDe(Pais pais){
        final PaisResponse paisResponse = new PaisResponse(pais.getNome());

        paisResponse.id = pais.getId();

        return paisResponse;
    }
}
