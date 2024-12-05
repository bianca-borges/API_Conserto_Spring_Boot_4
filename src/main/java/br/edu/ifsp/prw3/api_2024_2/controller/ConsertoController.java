package br.edu.ifsp.prw3.api_2024_2.controller;

import br.edu.ifsp.prw3.api_2024_2.conserto.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.Optional;

@RestController
@RequestMapping("consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosConserto dados,
                                    UriComponentsBuilder uriBuilder) {
        var conserto = new Conserto(dados);

        repository.save( conserto );

        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(conserto.getId()).toUri();

        return ResponseEntity.created(uri).body( new DadosDetalhamentoConserto(conserto) );
    }

    @GetMapping
    public ResponseEntity listarTodos(Pageable paginacao) {

        var pagina = repository.findAll(paginacao).map(DadosListagemConserto::new);
        return ResponseEntity.ok(pagina);
    }


    @GetMapping("algunsdados")
    public ResponseEntity listarAlgunsDados() {

        var lista = repository.findAllByAtivoTrue().stream()
                .map(DadosListagemConserto::new)
                .toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id) {
        Optional<Conserto> consertoOptional = repository.findById(id);

        if (consertoOptional.isPresent()) {
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados) {
        Conserto conserto = repository.getReferenceById(dados.id());
        conserto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Conserto conserto = repository.getReferenceById(id);

        conserto.excluir();

        return ResponseEntity.noContent().build();
    }

}
