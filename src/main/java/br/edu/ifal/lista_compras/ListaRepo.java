package br.edu.ifal.lista_compras;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaRepo extends CrudRepository<Item, Long>{

}