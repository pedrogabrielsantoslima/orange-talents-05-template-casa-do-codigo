package br.com.zup.pedro.casadocodigo.controller;

import br.com.zup.pedro.casadocodigo.model.Cliente;
import br.com.zup.pedro.casadocodigo.repository.ClienteRepository;
import br.com.zup.pedro.casadocodigo.request.ClienteRequest;
import br.com.zup.pedro.casadocodigo.response.BaseResponse;
import br.com.zup.pedro.casadocodigo.response.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public BaseResponse<List<ClienteResponse>> listar(){
        return new BaseResponse<>(clienteRepository.findAll()
                .stream()
                .map(ClienteResponse::converterDe)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrar(@RequestBody @Valid ClienteRequest clienteRequest){
        Cliente cliente = clienteRepository.save(clienteRequest.toModel());

        return ResponseEntity
                .created(UriComponentsBuilder.fromPath(String.format("/clientes/%s", cliente.getId())).build().toUri())
                .body(ClienteResponse.converterDe(cliente));
    }
}
