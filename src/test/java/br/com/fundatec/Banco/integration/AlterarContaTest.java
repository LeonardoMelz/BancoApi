package br.com.fundatec.Banco.integration;

import org.hamcrest.Matchers;
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
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AlterarContaTest {
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
	}
	@Test
	public void deveAlterarConta() {
		Conta conta = new Conta(null, "Corrente", 2000L );
		conta = contaRepository.save(conta);
		RestAssured
		.given()
		.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		.body("{" + 

				"	\"tipoConta\": \"Corrente\"," + 
				"	\"saldo\": 3000 , "  + 
				"}")
		.when()
		.put("/v1/contas/{id}",conta.getId())
		.then ()
		.assertThat()
		.statusCode(HttpStatus.OK.value())
		.body("id",Matchers.equalTo(conta.getId().intValue()))
		.body("tipoConta",Matchers.equalTo("Corrente"))
		.body("saldo",Matchers.equalTo(3000L));
		Conta contaAlterada = contaRepository.findById(conta.getId()).get();	
		Assert.assertEquals("Corrente", contaAlterada.getTipoConta());
		Assert.assertEquals(3000L, contaAlterada.getSaldo().intValue());
	}

}