package br.com.svieira.crudpostgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudPostgresApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudPostgresApplication.class, args); {
			System.out.println("Aplicação CRUD de Produtos");
		}

	}
}
