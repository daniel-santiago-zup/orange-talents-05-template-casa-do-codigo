package br.com.zupacademy.daniel.casadocodigo.repository;

import br.com.zupacademy.daniel.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
