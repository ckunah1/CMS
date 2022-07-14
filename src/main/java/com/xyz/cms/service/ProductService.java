package com.xyz.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.xyz.cms.exception.CMSException;
import com.xyz.cms.model.Product;
import com.xyz.cms.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	public Product getProduct(int productId) throws CMSException {
		return productRepo.findById(productId).orElseThrow(() -> new CMSException(HttpStatus.NOT_FOUND.value(), 
				"error code. The product could not be found."));
	}
	
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}
	
	public Product addProduct(Product product) {
		if(product != null && product.getProductId() > 0) {
			return productRepo.save(product);
		}
		
		return null;
	}
}
