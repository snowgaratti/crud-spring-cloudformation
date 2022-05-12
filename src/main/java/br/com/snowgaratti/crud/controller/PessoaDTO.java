package br.com.snowgaratti.crud.controller;

import java.time.LocalDate;

public record PessoaDTO(String id, String nome, String sobrenome,
                        String email) {
}
