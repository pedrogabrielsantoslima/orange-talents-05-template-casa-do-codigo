package br.com.zup.pedro.casadocodigo.config;

import br.com.zup.pedro.casadocodigo.model.Autor;
import br.com.zup.pedro.casadocodigo.repository.AutorRepository;
import br.com.zup.pedro.casadocodigo.request.AutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoValidator implements Validator {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        AutorRequest autorRequest = (AutorRequest) object;

        Optional<Autor> optionalAutor = autorRepository.findByEmail(autorRequest.getEmail());
        if(optionalAutor.isPresent()){
            errors.rejectValue("email", null, "Email ja existe");
        }
    }
}
