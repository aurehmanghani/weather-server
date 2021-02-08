package com.api.weatherserver.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class WeatherController {
	
	@GetMapping("/weather/{CCName}")
	public String findByCity(@PathVariable("CCName") String CCName) {
		try {
			final String uri = "http://api.openweathermap.org/data/2.5/weather?q="+CCName+"&appid=cd54b7fbdaf08c6e9677d93bfb7a35b2";

		    RestTemplate restTemplate = new RestTemplate();
		    String result = restTemplate.getForObject(uri, String.class);
		    
		    return result;
		    
		}catch (Exception e) {
			
			return "false";
		}
	    
	    
	}
	
	@GetMapping("/weather/{lat}/{lon}")
	public String findByLatLon(@PathVariable("lat") String lat,@PathVariable("lon") String lon) {
		try {
			final String uri = "http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=cd54b7fbdaf08c6e9677d93bfb7a35b2";

		    RestTemplate restTemplate = new RestTemplate();
		    String result = restTemplate.getForObject(uri, String.class);
		    return result;
		} catch (Exception e) {
			return "false";
		}
	    
	    
	}
	
}
