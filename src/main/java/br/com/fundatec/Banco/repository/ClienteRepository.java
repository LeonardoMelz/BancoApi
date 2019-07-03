package br.com.fundatec.Banco.repository;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fundatec.Banco.entity.Cliente;



@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}