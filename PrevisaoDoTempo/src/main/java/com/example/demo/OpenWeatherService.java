package com.example.demo;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

@Service
public class OpenWeatherService {

	private final String API_KEY = "289da870203bdd5a667b37a5efd114ae";
	private final String URL_PREVISAO_TEMPO = "http://api.openweathermap.org/data/2.5/forecast?q={cidade},{pais}&appid={api}&lang=pt_br&units=metric&cnt=10";

	
	public ResponseEntity<String> previsaoTempo(String cidade, String pais) {

		URI url = new UriTemplate(URL_PREVISAO_TEMPO).expand(cidade, pais, this.API_KEY);
 
		System.out.println(url.toString());
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		
		return response;
		
	}
}
