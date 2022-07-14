package com.xyz.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyz.cms.model.Customer;

@SpringBootApplication
public class CmsApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CmsApplication.class, args);
		
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setDescription("paid");
		customer.setEmail("gmail");
		customer.setCustName("kc");
		customer.setActive(true);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(customer);
		System.out.println(jsonString);
	}

}
