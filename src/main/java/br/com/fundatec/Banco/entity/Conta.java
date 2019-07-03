package br.com.fundatec.Banco.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipoConta;
	private Long saldo;
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	
	public Conta() {
		
	}
	
	public Conta(Long id, String tipoConta, Long saldo) {
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

	public void setCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
