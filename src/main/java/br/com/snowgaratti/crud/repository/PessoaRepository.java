package br.com.snowgaratti.crud.repository;

import br.com.snowgaratti.crud.entity.Pessoa;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface PessoaRepository extends CrudRepository<Pessoa, String> {
    Optional<Pessoa> findByEmail(String email);
}
