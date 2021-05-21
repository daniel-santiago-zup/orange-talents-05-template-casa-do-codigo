package br.com.zupacademy.daniel.casadocodigo.repository;

import br.com.zupacademy.daniel.casadocodigo.model.Estado;
import org.springframework.data.repository.CrudRepository;

public interface EstadoRepository extends CrudRepository<Estado,Long> {
    boolean existsByIdAndPaisId(Long idEstado, Long idPais);
    boolean existsByPaisId(Long idPais);
    boolean existsByNomeAndPaisId(String nome, Long idPais);
}
