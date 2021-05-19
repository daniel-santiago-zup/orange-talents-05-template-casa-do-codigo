package br.com.zupacademy.daniel.casadocodigo.repository;

import br.com.zupacademy.daniel.casadocodigo.model.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, Long> {

}
