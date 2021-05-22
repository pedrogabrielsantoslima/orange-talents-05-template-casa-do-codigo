package br.com.zup.pedro.casadocodigo.request;

import br.com.zup.pedro.casadocodigo.model.Autor;
import br.com.zup.pedro.casadocodigo.validator.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class AutorRequest implements Serializable {

    private static final long serialVersionUID = 1159409202298668221L;

    @NotBlank(message = "O nome é obrigatório")
    @Length(min = 3, max = 255, message = "O nome deverá ter entre {min} e {max} caracteres")
    private final String nome;

    @Length(min = 10, max = 255, message = "O email deverá ter entre {min} e {max} caracteres")
    @Email
    @UniqueValue(fieldName = "email", model = Autor.class)
    private final String email;

    @NotBlank(message = "A descrição é obrigatória")
    @Length(min = 1, max = 400, message = "A descricao deverá ter entre {min} e {max} caracteres")
    private final String descricao;

    public AutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor toModel() {
        return new Autor(nome, email, descricao);
    }
}
