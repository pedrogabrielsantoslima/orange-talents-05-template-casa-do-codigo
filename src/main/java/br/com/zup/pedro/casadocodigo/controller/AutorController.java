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
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public List<AutorResponse> listar(){
       return autorRepository.findAll()
               .stream()
               .map(AutorResponse::converterDe)
               .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<AutorResponse> cadastrar(@Valid @RequestBody AutorRequest autorRequest){
        Autor autor = autorRepository.save(autorRequest.toModel());

        return ResponseEntity
                .created(UriComponentsBuilder.fromPath(String.format("/autores/%s", autor.getId())).build().toUri())
                .body(AutorResponse.converterDe(autor));
    }
}
