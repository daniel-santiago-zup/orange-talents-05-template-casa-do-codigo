package br.com.zupacademy.daniel.casadocodigo.repository;

import br.com.zupacademy.daniel.casadocodigo.model.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria,Long> {
    boolean existsByNome(String nome);
}
