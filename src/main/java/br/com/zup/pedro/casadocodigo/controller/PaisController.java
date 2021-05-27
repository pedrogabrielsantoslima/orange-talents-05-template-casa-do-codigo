package br.com.zup.pedro.casadocodigo.controller;

import br.com.zup.pedro.casadocodigo.model.Pais;
import br.com.zup.pedro.casadocodigo.repository.PaisRepository;
import br.com.zup.pedro.casadocodigo.request.PaisRequest;
import br.com.zup.pedro.casadocodigo.response.BaseResponse;
import br.com.zup.pedro.casadocodigo.response.PaisResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/paises")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @GetMapping
    public BaseResponse<List<PaisResponse>> listar(){
        return new BaseResponse<>(paisRepository.findAll()
                .stream()
                .map(PaisResponse::converterDe)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<PaisResponse> cadastrar(@RequestBody @Valid PaisRequest paisRequest){
        Pais pais = paisRepository.save(paisRequest.toModel());

        return ResponseEntity
                .created(UriComponentsBuilder.fromPath(String.format("/paises/%s", pais.getId())).build().toUri())
                .body(PaisResponse.converterDe(pais));
    }
}
