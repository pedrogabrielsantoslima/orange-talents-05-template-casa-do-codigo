package br.com.zup.pedro.casadocodigo.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public class AutorRequest {

    @NotBlank(message = "O nome é obrigatório")
    @Max(255)
    private final String nome;

    @NotBlank
    @Max(255)
    @Email
    private final String email;

    @NotBlank
    @Max(400)
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
}
