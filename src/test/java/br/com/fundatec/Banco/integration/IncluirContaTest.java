package br.com.fundatec.Banco.integration;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;


import br.com.fundatec.Banco.entity.Cliente;
import br.com.fundatec.Banco.entity.Conta;
import br.com.fundatec.Banco.repository.ClienteRepository;
import br.com.fundatec.Banco.repository.ContaRepository;
import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IncluirContaTest {
	
	@LocalServerPort
	private int port;
	@Autowired
	private ContaRepository contaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	private Cliente cliente;
	
	
	
	@Before
	public void setUp() {
		RestAssured.port = port;
		RestAssured.baseURI = "http://localhost";
		contaRepository.deleteAll();
		cliente = clienteRepository.save(new Cliente(null, "Leonardo", 18, "Rua Dante Angelo Pilla", "933481419"));
	}
	
	@Test
	public void deveIncluirUmaConta() {
		RestAssured
			.given()
			.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
			.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			.body("{" + 
					"	\"tipoConta\": \"Corrente\"," + 
					"	\"saldo\": 0" + 
					"    \"idCliente\":"+cliente.getId() +
					"}")
			.when()
			.post("/v1/contas")
			.then()
			.assertThat()
			.body("tipoConta", Matchers.equalTo("Corrente"))
			.body("saldo", Matchers.equalTo (0))
			.body("id", Matchers.greaterThan(0))
			
			.statusCode(HttpStatus.CREATED.value());
	
		Conta contaIncluido = ((List<Conta>)contaRepository.findAll()).get(0); 
		
		
		Assert.assertTrue(contaRepository.count() > 0); 
		
	}
	
	@Test
	public void deveValidarTipoDaConta() {
		
		RestAssured
		.given()
		.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		.body("{" + 
				"	\"tipoConta\": \"Conta Corrente\"," + 
				"	\"saldo\": 0" + 
				"}")
		.when()
		.post("/v1/contas")
		.then()
		.assertThat()
		.statusCode(HttpStatus.BAD_REQUEST.value())
		.body("errors[0].defaultMessage", Matchers.equalTo("Campo tipo da conta invalido"));
		Assert.assertTrue(contaRepository.count() == 0);
}
	
	
}