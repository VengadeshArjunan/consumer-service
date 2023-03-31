package com.example.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	@Autowired
	private RestTemplate restTemplate;
	@GetMapping("/message")
	public String message() {
		String url = "http://producer-service/message";
		return restTemplate.getForObject(url, String.class);
	}
}
