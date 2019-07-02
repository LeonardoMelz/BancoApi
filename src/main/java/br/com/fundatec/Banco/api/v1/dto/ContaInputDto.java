package br.com.fundatec.Banco.api.v1.dto;

public class ContaInputDto {
	
	private String tipoConta; 
	private Long saldo;
	
	
	
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
