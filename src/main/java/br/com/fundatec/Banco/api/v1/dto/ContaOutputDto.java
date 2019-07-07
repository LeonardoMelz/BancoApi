package br.com.fundatec.Banco.api.v1.dto;

public class ContaOutputDto {
	private Long id;
	private String tipoConta;
	private Long saldo;

	public ContaOutputDto() {

	}

	public ContaOutputDto(Long id, String tipoConta, Long saldo) {
		this.id = id;
		this.tipoConta = tipoConta;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
