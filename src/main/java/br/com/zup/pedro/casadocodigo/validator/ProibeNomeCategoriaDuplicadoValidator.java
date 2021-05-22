package br.com.zup.pedro.casadocodigo.validator;

import br.com.zup.pedro.casadocodigo.model.Categoria;
import br.com.zup.pedro.casadocodigo.repository.CategoriaRepository;
import br.com.zup.pedro.casadocodigo.request.CategoriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeNomeCategoriaDuplicadoValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CategoriaRequest categoriaRequest = (CategoriaRequest) object;

        Optional<Categoria> optionalCategoria = categoriaRepository.findByNome(categoriaRequest.getNome());
        if(optionalCategoria.isPresent()){
            errors.rejectValue("nome", "Nome ja existe");
        }
    }
}
