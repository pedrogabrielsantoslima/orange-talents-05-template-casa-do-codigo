package br.com.zup.pedro.casadocodigo.request;

import br.com.zup.pedro.casadocodigo.model.Pais;
import br.com.zup.pedro.casadocodigo.response.PaisResponse;
import br.com.zup.pedro.casadocodigo.validator.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class PaisRequest {

    @NotBlank(message = "O nome é obrigatório")
    @UniqueValue(fieldName = "nome", model = Pais.class)
    private String nome;

    @Deprecated
    public PaisRequest(){}

    public PaisRequest(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Pais toModel() {
        return new Pais(nome);
    }
}
