package br.com.zup.pedro.casadocodigo.repository;

import br.com.zup.pedro.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

    Optional<Autor> findByEmail(String email);
}
