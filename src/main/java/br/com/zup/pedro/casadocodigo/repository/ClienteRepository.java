package br.com.zup.pedro.casadocodigo.repository;

import br.com.zup.pedro.casadocodigo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
