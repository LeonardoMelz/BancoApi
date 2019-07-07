package br.com.fundatec.Banco.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fundatec.Banco.entity.Conta;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Long> {

}
