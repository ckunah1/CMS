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
import com.xyz.cms.model.Product;
import com.xyz.cms.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	ObjectMapper objMapper = new ObjectMapper();
	
	@GetMapping("/get/{productId}")
	public String getProductById(@PathVariable int productId) throws JsonProcessingException {
		try {
			Product product = productService.getProduct(productId);
			
			return objMapper.writeValueAsString(product);
		} catch (CMSException e) {
			return e.getErrorCode() + " " + e.getErrorMessage();
		}
	}

	@GetMapping("/getAll")
	public List<Product> getAllProducts() {		
		return productService.getAllProducts();
	}

	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) throws JsonProcessingException {
		Product productObj = productService.addProduct(product);
		
		return objMapper.writeValueAsString(productObj);
	}
}
