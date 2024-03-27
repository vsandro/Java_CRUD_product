package br.com.svieira.crudpostgres.controller;

import br.com.svieira.crudpostgres.entity.Produto;
import br.com.svieira.crudpostgres.repository.Produtos;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private Produtos repository;
    public ProdutoController(Produtos repository) {
        this.repository = repository;
    }
    @PostMapping
    @ResponseStatus(CREATED)
    public Produto save( @RequestBody Produto produto ) {
        repository.save(produto);
        return repository.save(produto);
    }

    @GetMapping("{id}")
    public Produto getById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow( () -> new ResponseStatusException(NOT_FOUND, "Produto não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Produto produto) {
        repository.findById(id).map( p -> {
            produto.setId( p.getId());
            repository.save(produto);
            return produto;
        }).orElseThrow( () -> new ResponseStatusException(NOT_FOUND, "Produto não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        repository.findById(id).map( p -> {
            repository.delete(p);
            return Void.TYPE;
        }).orElseThrow( () -> new ResponseStatusException(NOT_FOUND, "Produto não encontrado"));
    }

    @GetMapping
    public Iterable<Produto> find() {
        return repository.findAll();
    }

}
