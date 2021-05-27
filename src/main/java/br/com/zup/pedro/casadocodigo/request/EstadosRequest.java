package br.com.zup.pedro.casadocodigo.request;

import br.com.zup.pedro.casadocodigo.model.Estados;
import br.com.zup.pedro.casadocodigo.model.Pais;
import br.com.zup.pedro.casadocodigo.validator.ExistsId;
import br.com.zup.pedro.casadocodigo.validator.UniqueValue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadosRequest {

    @NotBlank(message = "O nome é obrigatório")
    @UniqueValue(fieldName = "nome", model = Estados.class)
    private String nome;

    @NotNull(message = "O País é obrigatório")
    @ExistsId(fieldName = "id", model = Pais.class)
    private Integer idPais;

    public EstadosRequest(String nome, Integer idPais){

        this.nome = nome;
        this.idPais = idPais;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public Estados toModel(){
        Pais pais = new Pais(idPais);

        return new Estados(nome, pais);
    }
}
