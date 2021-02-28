package br.com.gerenciaevento.gerenciaevento.repository;

import br.com.gerenciaevento.gerenciaevento.model.SalaEvento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SalaEventoRepository extends CrudRepository<SalaEvento, Long> {

    List<SalaEvento> findByName(String name);
}
