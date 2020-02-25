package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PrevisaoDoTempoControllerTest {

	private OpenWeatherService openWeatherService;

	@Test
	public void pesquisaSaoPauloOK() throws Exception, JsonProcessingException {
		this.openWeatherService = new OpenWeatherService();		
		ResponseEntity<String> response = openWeatherService.previsaoTempo("sao+paulo", "brazil");
		System.out.println(response.toString());
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		JsonNode city = root.path("city");
		assertEquals(city.get("name").asText(), "Sao Paulo");
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void pesquisaRioDeJaneiroOK() throws Exception, JsonProcessingException {
		this.openWeatherService = new OpenWeatherService();		
		ResponseEntity<String> response = openWeatherService.previsaoTempo("rio+de+janeiro", "brazil");
		System.out.println(response.toString());
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		JsonNode city = root.path("city");
		assertEquals(city.get("name").asText(), "Rio de Janeiro");
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void pesquisaBrasiliaOK() throws Exception, JsonProcessingException {
		this.openWeatherService = new OpenWeatherService();		
		ResponseEntity<String> response = openWeatherService.previsaoTempo("brasilia", "brazil");
		System.out.println(response.toString());
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		JsonNode city = root.path("city");
		assertEquals(city.get("name").asText(), "Brasilia");
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	//Este teste foi feito para NÃO PASSAR
	@Test
	public void pesquisaTangamandapioOK() throws JsonMappingException, Exception {
		this.openWeatherService = new OpenWeatherService();		
		ResponseEntity<String> response = openWeatherService.previsaoTempo("tangamandapio", "brazil");
		System.out.println(response.toString());
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		JsonNode city = root.path("city");
		assertEquals(city.get("name").asText(), "Tangamandapio");
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	//Este teste foi feito para PASSAR NA EXCEÇÃO!
	@Test(expected = HttpClientErrorException.class)
	public void pesquisaTangamandapioNOK() throws Exception, JsonProcessingException {
		
		this.openWeatherService = new OpenWeatherService();		
		ResponseEntity<String> response = openWeatherService.previsaoTempo("tangamandapio", "brazil");
		System.out.println(response.toString());
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		JsonNode city = root.path("city");
		assertEquals(city.get("name").asText(), "Tangamandapio");
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
}
