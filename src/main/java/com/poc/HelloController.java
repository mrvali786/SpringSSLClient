package com.poc;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class HelloController {

	@GetMapping("/send")
	public ResponseEntity<String> message() {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> result = restTemplate.exchange("https://localhost:8080/test/send", HttpMethod.GET, null,
				String.class);
		return new ResponseEntity<>(result.getBody(), HttpStatus.OK);
	}

}
