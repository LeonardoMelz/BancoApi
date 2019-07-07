package br.com.fundatec.Banco.api.v1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ContaInputDto {
	@NotBlank(message = "O campo tipo da conta não foi preenchido")
	@Pattern(regexp = "^Corrente$|^Popança$", message = "Campo tipo da conta invalido")
	private String tipoConta;
	private Long saldo;
	private Long idCliente;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Long getSaldo() {
		return saldo;
	}

	public void setSaldo(Long saldo) {
		this.saldo = saldo;
	}

}
