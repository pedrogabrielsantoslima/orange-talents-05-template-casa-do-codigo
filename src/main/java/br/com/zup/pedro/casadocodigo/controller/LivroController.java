package br.com.zup.pedro.casadocodigo.controller;

import br.com.zup.pedro.casadocodigo.model.Livro;
import br.com.zup.pedro.casadocodigo.repository.LivroRepository;
import br.com.zup.pedro.casadocodigo.request.LivroRequest;
import br.com.zup.pedro.casadocodigo.response.LivroResponse;
import br.com.zup.pedro.casadocodigo.response.BaseResponse;
import br.com.zup.pedro.casadocodigo.view.LivroResumidoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
   private LivroRepository livroRepository;

    @GetMapping("/{id}")
    public BaseResponse<List<LivroResponse>> listar(@PathVariable Integer id){
            return new BaseResponse<>(livroRepository.findById(id)
                    .stream()
                    .map(LivroResponse::converterDe)
                    .collect(Collectors.toList()));
    }

    @GetMapping
    public BaseResponse<List<LivroResumidoView>> listarLivrosResumidos(){
        return new BaseResponse<>(livroRepository.findAllLivroResumidoView());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<LivroResponse> cadastrar(@Valid @RequestBody LivroRequest livroRequest){
        Livro livro = livroRepository.save(livroRequest.toModel());

        return ResponseEntity
                .created(UriComponentsBuilder.fromPath(String.format("/livros/%s", livro.getId())).build().toUri())
                .body(LivroResponse.converterDe(livro));
    }
}
