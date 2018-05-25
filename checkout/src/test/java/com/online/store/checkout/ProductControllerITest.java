package com.online.store.checkout;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.springframework.http.HttpStatus; 

@RunWith(SpringRunner.class) 
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) 
public class ProductControllerITest { 
	
	@Value("${local.server.port}")
	private int localServerPort;
	
	@Test 
	public void test() { 
		RestTemplate restTemplate = new RestTemplate(); 
		ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:{port}/store/checkout/products/{type}", List.class, 
		                 localServerPort, "Type 01"); 
		
		System.out.println("Response : " + response.getBody());
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK); 
		assertThat(response.getBody().toString().contains("Type 01")); 
	}
}