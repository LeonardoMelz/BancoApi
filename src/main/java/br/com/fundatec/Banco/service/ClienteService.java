package br.com.fundatec.Banco.service;

import org.springframework.stereotype.Service;

import br.com.fundatec.Banco.entity.Cliente;
import br.com.fundatec.Banco.repository.ClienteRepository;

@Service
public class ClienteService {

	private  ClienteRepository clienteRepository;

	public  ClienteService( ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente consultar(Long id) {
		
		return clienteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Năo encontrou pessoa para esse id "+id));
	}

	}