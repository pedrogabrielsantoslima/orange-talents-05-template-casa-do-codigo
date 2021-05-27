package br.com.zup.pedro.casadocodigo.controller;

import br.com.zup.pedro.casadocodigo.model.Estados;
import br.com.zup.pedro.casadocodigo.model.Pais;
import br.com.zup.pedro.casadocodigo.repository.EstadosRepository;
import br.com.zup.pedro.casadocodigo.request.EstadosRequest;
import br.com.zup.pedro.casadocodigo.response.BaseResponse;
import br.com.zup.pedro.casadocodigo.response.EstadosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/estados")
public class EstadosController {

    @Autowired
    private EstadosRepository estadosRepository;

    @GetMapping
    public BaseResponse<List<EstadosResponse>> listar(){
        return new BaseResponse<>(estadosRepository.findAll()
                .stream()
                .map(EstadosResponse::converterDe)
                .collect(Collectors.toList()));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EstadosResponse> cadastrar(@Valid @RequestBody EstadosRequest estadosRequest){
        Estados estados = estadosRepository.save(estadosRequest.toModel());

        return ResponseEntity
                .created(UriComponentsBuilder.fromPath(String.format("/estados/%s", estados.getId())).build().toUri())
                .body(EstadosResponse.converterDe(estados));
    }

}
