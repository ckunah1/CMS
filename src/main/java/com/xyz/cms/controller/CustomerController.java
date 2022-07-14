package com.xyz.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyz.cms.exception.CMSException;
import com.xyz.cms.model.Customer;
import com.xyz.cms.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	ObjectMapper objectMapper = new ObjectMapper();
	String jsonString;
	
	@GetMapping("/getCustomer/{customerId}")
	public String getCustomer(@PathVariable int customerId) throws JsonProcessingException {
		try {
			Customer customer = customerService.getCustomerById(customerId);
			
			return objectMapper.writeValueAsString(customer);
		} catch (CMSException e) {
			System.out.println(e.getErrorMessage());
			
			return e.getErrorCode() + " " + e.getErrorMessage();
		}
	}
	
	@GetMapping("/getCustomerOld/{customerId}")
	public ResponseEntity<Customer> getCustomerOld(@PathVariable int customerId) {
		ResponseEntity<Customer> responseEntity = null;
		
		try {
			responseEntity = new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);

			return responseEntity;
		} catch (CMSException e) {
			responseEntity = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			
			return responseEntity;
		}
		
	}

	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody Customer customer) throws JsonProcessingException {
		Customer customerObj = customerService.addCustomer(customer);

		return objectMapper.writeValueAsString(customerObj);
	}
}


/*  
	@GetMapping("/getCustomer/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int customerId) {
		ResponseEntity<Customer> responseEntity = null;
		
		try {
			responseEntity = new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
		} catch (CMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			responseEntity = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return responseEntity;
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws JsonProcessingException {
		ResponseEntity<Customer> responseEntity = null;
		
		if (customer != null && customer.getCustomerId() > 0) {
			Customer customerObj = customerService.addCustomer(customer);
			responseEntity = new ResponseEntity<>(customerObj, HttpStatus.CREATED);
			jsonString = objectMapper.writeValueAsString(customerObj);
			System.out.println(jsonString);
		}

		return responseEntity;
	}
*/