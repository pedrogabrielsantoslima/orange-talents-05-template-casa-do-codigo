package br.com.zup.pedro.casadocodigo.request;

import br.com.zup.pedro.casadocodigo.model.Categoria;
import br.com.zup.pedro.casadocodigo.validator.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class CategoriaRequest implements Serializable {

    private static final long serialVersionUID = -5220816760461208290L;

    @NotBlank(message = "O nome é obrigatório")
    @Length(min = 1, max = 255, message = "O nome deverá ter entre {min} e {max} caracteres")
    @UniqueValue(fieldName = "nome", model = Categoria.class)
    private String nome;

    @Deprecated
    public CategoriaRequest(){}

    public CategoriaRequest(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(nome);
    }
}