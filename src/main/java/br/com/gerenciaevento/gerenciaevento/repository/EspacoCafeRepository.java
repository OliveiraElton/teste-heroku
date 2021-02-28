package br.com.gerenciaevento.gerenciaevento.repository;

import br.com.gerenciaevento.gerenciaevento.model.EspacoCafe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspacoCafeRepository extends CrudRepository<EspacoCafe, Long> {

    List<EspacoCafe> findById(String id);

}
