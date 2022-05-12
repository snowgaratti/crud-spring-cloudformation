package br.com.snowgaratti.crud.controller;

import br.com.snowgaratti.crud.service.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;
    private final PessoaMapper pessoaMapper;

    public PessoaController(PessoaService pessoaService, PessoaMapper pessoaMapper) {
        this.pessoaService = pessoaService;
        this.pessoaMapper = pessoaMapper;
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody PessoaDTO pessoaDTO) {
        try {
            if (pessoaDTO != null) {
                var pessoaSalvar = pessoaMapper.toPojo(pessoaDTO);
                var pessoaSalva = pessoaService.salvar(pessoaSalvar);

                return ResponseEntity.ok(pessoaMapper.toDTO(pessoaSalva));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

        return ResponseEntity.internalServerError().build();
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> listarTodos() {
        var pessoasBuscadas = pessoaService.listarTodos();
        return ResponseEntity.ok(pessoasBuscadas.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/buscar-por-email")
    public ResponseEntity<PessoaDTO> buscarPorEmail(@RequestParam("email") String email) {
        var pessoaBuscada = pessoaService.buscarPorEmail(email);

        return pessoaBuscada.map(pessoa -> ResponseEntity.ok(pessoaMapper.toDTO(pessoa))).orElseGet(() -> ResponseEntity.notFound()
                .build());

    }
}
