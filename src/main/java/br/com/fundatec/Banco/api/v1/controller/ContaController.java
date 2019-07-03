package br.com.fundatec.Banco.api.v1.controller;
 
import java.util.List;

import javax.validation.Valid;

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
	public ResponseEntity<ContaOutputDto> incluirConta(@Valid @RequestBody ContaInputDto contaInputDto) {
		Conta conta = contaMapper.mapearConta(contaInputDto);
		conta = contaService.incluir(conta);
		ContaOutputDto contaOutputDto = contaMapper.mapearContaOutputDto(conta);

		return ResponseEntity.status(HttpStatus.CREATED).body(contaOutputDto);
	}

	@GetMapping("/v1/contas")
	public ResponseEntity<List<ContaOutputDto>> getCachorros() {

		List<Conta> listaCachorro = contaService.listarTodos();
		List<ContaOutputDto> listaContaDto = contaMapper.mapearListaContaOutputDto(listaCachorro);



		return ResponseEntity.status(HttpStatus.OK).body(listaContaDto);
	

}
	}
