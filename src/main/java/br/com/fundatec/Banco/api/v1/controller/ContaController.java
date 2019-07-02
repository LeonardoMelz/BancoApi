package br.com.fundatec.Banco.api.v1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fundatec.Banco.api.v1.dto.ContaInputDto;
import br.com.fundatec.Banco.api.v1.dto.ContaOutputDto;
import br.com.fundatec.Banco.entity.Conta;
import br.com.fundatec.Banco.mapper.ContaMapper;
import br.com.fundatec.Banco.service.ContaService;

@RestController
public class ContaController {
	
	private ContaService contaService;
	private ContaMapper contaMapper;
	
	
	public ContaController(ContaService contaService, ContaMapper contaMapper) {
		this.contaService = contaService;
		this.contaMapper = contaMapper;
	}
  


	@PostMapping("/v1/contas")
	public ResponseEntity<ContaOutputDto> incluirConta(@RequestBody ContaInputDto contaInputDto) {
		Conta conta = contaMapper.mapearConta(contaInputDto);
		conta = contaService.incluir(conta);
		ContaOutputDto contaOutputDto = contaMapper.mapearContaOutputDto(conta);

		return ResponseEntity.status(HttpStatus.CREATED).body(contaOutputDto);
	}

	

}
