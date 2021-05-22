package br.com.zup.pedro.casadocodigo.controller;

import br.com.zup.pedro.casadocodigo.model.Categoria;
import br.com.zup.pedro.casadocodigo.repository.CategoriaRepository;
import br.com.zup.pedro.casadocodigo.request.CategoriaRequest;
import br.com.zup.pedro.casadocodigo.response.CategoriaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<CategoriaResponse> listar(){
        return categoriaRepository.findAll()
                .stream()
                .map(CategoriaResponse::converterDe)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<CategoriaResponse> cadastrar(@Valid @RequestBody CategoriaRequest categoriaRequest){
        final Categoria categoria = categoriaRepository.save(categoriaRequest.toModel());

        return ResponseEntity
                .created(UriComponentsBuilder.fromPath(String.format("/categorias/%s", categoria.getId())).build().toUri())
                .body(CategoriaResponse.converterDe(categoria));
    }
}
