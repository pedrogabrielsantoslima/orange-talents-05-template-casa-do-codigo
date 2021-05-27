package br.com.zup.pedro.casadocodigo.response;

import br.com.zup.pedro.casadocodigo.model.Estados;
import br.com.zup.pedro.casadocodigo.request.EstadosRequest;

public class EstadosResponse extends EstadosRequest {

    private Integer id;

    public EstadosResponse(String nome, Integer idPais) {
        super(nome, idPais);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static EstadosResponse converterDe(Estados estados){
        EstadosResponse estadosResponse = new EstadosResponse(estados.getNome(), estados.getPais().getId());

        estadosResponse.id = estados.getId();

        return estadosResponse;
    }
}
