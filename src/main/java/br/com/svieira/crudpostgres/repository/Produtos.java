package br.com.svieira.crudpostgres.repository;

import br.com.svieira.crudpostgres.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {

}
