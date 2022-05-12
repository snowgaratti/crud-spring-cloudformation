package br.com.snowgaratti.crud.service;

import br.com.snowgaratti.crud.entity.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaService {

    Pessoa salvar(Pessoa pessoa);

    Optional<Pessoa> buscarPorEmail(String email);

    List<Pessoa> listarTodos();
}
