package br.com.fundatec.Banco.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fundatec.Banco.entity.Conta;
import br.com.fundatec.Banco.repository.ContaRepository;


@Service
public class ContaService {

	private ContaRepository contaRepository;
	
	public ContaService(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}

	public List<Conta> listarTodos() {
		return (List<Conta>) contaRepository.findAll();
	}
	
	public Conta salvar(Conta conta) {	
		return contaRepository.save(conta);
		
	}

	
}
