package br.com.zup.pedro.casadocodigo.repository;

import br.com.zup.pedro.casadocodigo.model.Livro;
import br.com.zup.pedro.casadocodigo.view.LivroResumidoView;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    @Query("SELECT l FROM Livro l")
    List<LivroResumidoView> findAllLivroResumidoView();
}
