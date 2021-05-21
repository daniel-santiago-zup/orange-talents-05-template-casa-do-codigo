package br.com.zupacademy.daniel.casadocodigo.repository;

import br.com.zupacademy.daniel.casadocodigo.model.Estado;
import org.springframework.data.repository.CrudRepository;

public interface EstadoRepository extends CrudRepository<Estado,Long> {
    boolean existsByNomeAndPaisId(String nome, Long id);
}
