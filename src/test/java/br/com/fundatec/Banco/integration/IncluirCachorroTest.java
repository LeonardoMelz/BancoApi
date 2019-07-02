package br.com.fundatec.Banco.integration;

import org.hamcrest.Matcher;
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

import br.com.fundatec.Banco.repository.ContaRepository;
import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IncluirCachorroTest {
	
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
	public void deveIncluirUmaConta() {
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
			.body("tipoConta", Matchers.equalTo("Conta Corrente"))
			.body("saldo", Matchers.equalTo (0))
			.body("id", Matchers.greaterThan(0))
			
			.statusCode(HttpStatus.CREATED.value());
	
		Assert.assertTrue(contaRepository.count() > 0);
		
	}
	
	
}
