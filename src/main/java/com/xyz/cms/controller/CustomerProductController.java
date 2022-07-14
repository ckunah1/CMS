package com.xyz.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyz.cms.exception.CMSException;
import com.xyz.cms.model.CustomerProduct;
import com.xyz.cms.service.CustomerProductService;

@RestController
@RequestMapping("/customerProduct")
public class CustomerProductController {
	@Autowired
	private CustomerProductService customerProductService;
	ObjectMapper objMapper = new ObjectMapper();
	
	@GetMapping("/viewProducts/{customerId}")
	public String viewProducts(@PathVariable int customerId) throws JsonProcessingException {
		try {
			List<CustomerProduct> customerProductList = customerProductService.getProductsByCustomerId(customerId);
			return objMapper.writeValueAsString(customerProductList);
		} catch (CMSException e) {
			return e.getErrorCode() + " " + e.getErrorMessage();
		}
	}

	@PostMapping("/addProductToList")
	public String addProduct(@RequestBody CustomerProduct customerProduct) throws JsonProcessingException {
		try {
			CustomerProduct customerProductObj = customerProductService.addCustomerProduct(customerProduct);
			
			return objMapper.writeValueAsString(customerProductObj);
		} catch (CMSException e) {
			return e.getErrorCode() + " " + e.getErrorMessage();
		}
	}
}
