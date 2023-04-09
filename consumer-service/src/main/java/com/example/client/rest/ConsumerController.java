package com.example.client.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	@Autowired
	private RestTemplate restTemplate;
	
	Logger logger = LoggerFactory.getLogger(ConsumerController.class);
	
	@GetMapping("/message")
	public String message() {
		logger.info("*****Started fetching data from consumer using endpoint /message");
		String url = "http://producer-service/producer/message";
		String respose =  restTemplate.getForObject(url, String.class);
		logger.info("*****Finished fetching data from consumer using endpoint /message");
		return respose;
	}
	
	@GetMapping("/message/{id}")
	public String message(@PathVariable long id) {
		logger.debug("*****Started data from consumer using endpoint /message/id");
		String url = "http://producer-service/producer/message/"+id;
		String respose = restTemplate.getForObject(url, String.class);
		logger.debug("*****Finished fetching data from consumer using endpoint /message/id");
		return respose;
	}
}
