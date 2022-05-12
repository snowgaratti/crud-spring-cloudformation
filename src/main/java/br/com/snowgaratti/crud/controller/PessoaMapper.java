package br.com.snowgaratti.crud.controller;

import br.com.snowgaratti.crud.entity.Pessoa;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

    public PessoaDTO toDTO(Pessoa pessoa) {
        return new PessoaDTO(pessoa.getId(), pessoa.getNome(), pessoa.getSobrenome(), pessoa.getEmail());
    }

    public Pessoa toPojo(PessoaDTO pessoaDTO) {
        return new Pessoa(pessoaDTO.id(), pessoaDTO.nome(), pessoaDTO.sobrenome(), pessoaDTO.email());
    }
}
