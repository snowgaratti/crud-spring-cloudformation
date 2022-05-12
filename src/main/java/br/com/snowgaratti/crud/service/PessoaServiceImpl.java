package br.com.snowgaratti.crud.service;

import br.com.snowgaratti.crud.entity.Pessoa;
import br.com.snowgaratti.crud.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        System.out.println("salvar");
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Optional<Pessoa> buscarPorEmail(String email) {
        System.out.println("Buscar por email");
        return pessoaRepository.findByEmail(email);
    }

    @Override
    public List<Pessoa> listarTodos() {
        System.out.println("Listar todos");
        return (List<Pessoa>) pessoaRepository.findAll();
    }
}
