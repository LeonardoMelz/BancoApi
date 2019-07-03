package br.com.fundatec.Banco.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;




@Entity
public class Cliente {

	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(length = 50, nullable = false)
		private String nome;

		@Min(value = 14)
		@Column(nullable = false)
		private Integer idade;

		private String endereços;
		
		@Min(value = 9)
		@Column(length = 9, nullable = false)
		private String contato;
		
		@OneToMany(mappedBy = "cliente")
		private List<Conta> conta;

		public Cliente(Long id, String nome, @Min(14) Integer idade, String endereços, @Min(9) String contato) {
			this.id = id;
			this.nome = nome;
			this.idade = idade;
			this.endereços = endereços;
			this.contato = contato;
			this.conta=conta;
		}

		public Cliente() {

		}

		public String getEndereços() {
			return endereços;
		}

		public void setEndereços(String endereços) {
			this.endereços = endereços;
		}

		public String getContato() {
			return contato;
		}

		public void setContato(String contato) {
			this.contato = contato;
		}

		public List<Conta> getConta() {
			return conta;
		}

		public void setConta(List<Conta> conta) {
			this.conta = conta;
		}


		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Integer getIdade() {
			return idade;
		}

		public void setIdade(Integer idade) {
			this.idade = idade;
		}

	}

