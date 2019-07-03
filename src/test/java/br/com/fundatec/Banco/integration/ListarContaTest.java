package br.com.fundatec.Banco.integration;


import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fundatec.Banco.entity.Conta;
import br.com.fundatec.Banco.repository.ContaRepository;
import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ListarContaTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Before
	public void setUp() {
		RestAssured.port = port;
		RestAssured.baseURI = "http://localhost";
		contaRepository.deleteAll();
	}
	
	@Test
	public void deveBuscarUmaListaDeContas() {
		contaRepository.save(new Conta(null, "popanca", (long) 2000));
		contaRepository.save(new Conta(null, "conta corrente",(long) 1000));
		
		RestAssured
			.get("/v1/contas")
			.then()
			.body("tipoConta", Matchers.hasItems("popanca", "conta corrente"))
			.body("saldo", Matchers.hasItems(2000, 1000))
			.statusCode(HttpStatus.OK.value());
	}

}
