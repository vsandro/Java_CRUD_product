package br.com.svieira.crudpostgres.repository;

import br.com.svieira.crudpostgres.entity.Produto;
import org.springframework.data.repository.CrudRepository;

public interface Produtos extends CrudRepository<Produto, Integer> {

}
