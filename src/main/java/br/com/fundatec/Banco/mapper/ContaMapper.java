package br.com.fundatec.Banco.mapper;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.fundatec.Banco.api.v1.dto.ContaInputDto;
import br.com.fundatec.Banco.api.v1.dto.ContaOutputDto;
import br.com.fundatec.Banco.entity.Conta;
@Component
public class ContaMapper {

	public ContaOutputDto mapearContaOutputDto(Conta conta) {
		return new ContaOutputDto(
				conta.getId(),
				conta.getTipoConta(), 
				conta.getSaldo());
				
	}
	
	public Conta mapearConta(ContaInputDto contaInputDto) {
		return new Conta(null,
				contaInputDto.getTipoConta(),
				contaInputDto.getSaldo());
		
	}

	public List<ContaOutputDto> mapearListaContaOutputDto(List<Conta>contas){
		List<ContaOutputDto> listaContaDto=new ArrayList<>();

		for(Conta conta : contas) {
			listaContaDto.add(mapearContaOutputDto(conta));
		}
			return listaContaDto;
		}

	

	}

