package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrevisaoDoTempoController {

	@Autowired
	OpenWeatherService openWeatherService;
	
	@GetMapping("/previsao/{cidade}/{pais}")
	@ResponseBody
	public ResponseEntity<String> pesquisaPrevisao(@PathVariable("cidade") String cidade, @PathVariable("pais") String pais) {
		
		ResponseEntity<String> response =  openWeatherService.previsaoTempo(cidade, pais);
		
		try {
			return response;
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
	}
}
