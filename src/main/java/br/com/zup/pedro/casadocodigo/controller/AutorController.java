package br.com.zup.pedro.casadocodigo.controller;

import br.com.zup.pedro.casadocodigo.model.Autor;
import br.com.zup.pedro.casadocodigo.repository.AutorRepository;
import br.com.zup.pedro.casadocodigo.request.AutorRequest;
import br.com.zup.pedro.casadocodigo.response.AutorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/autor")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @GetMapping
    public List<Autor> listaAutor(){
       return autorRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<AutorResponse> cadastrarAutor(@RequestBody @Valid AutorRequest autorRequest, UriComponentsBuilder uriBuilder){
        Autor autor = autorRequest.converter();
        autorRepository.save(autor);

        URI uri = uriBuilder.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(new AutorResponse(autor.getNome(), autor.getEmail(), autor.getDescricao()));
    }
}
