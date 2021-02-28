package br.com.gerenciaevento.gerenciaevento.repository;

import br.com.gerenciaevento.gerenciaevento.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

    List<Pessoa> findByName(String name);
}
