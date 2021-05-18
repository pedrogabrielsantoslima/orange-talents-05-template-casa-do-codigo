package br.com.zup.pedro.casadocodigo.response;

import br.com.zup.pedro.casadocodigo.model.Autor;
import br.com.zup.pedro.casadocodigo.request.AutorRequest;

import java.time.LocalDateTime;

public class AutorResponse extends AutorRequest {

    private Integer id;
    private LocalDateTime instante;

    public AutorResponse(String nome, String email, String descricao) {
        super(nome, email, descricao);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public void setInstante(LocalDateTime instante) {
        this.instante = instante;
    }
}
