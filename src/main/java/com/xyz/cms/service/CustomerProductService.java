package com.xyz.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.xyz.cms.exception.CMSException;
import com.xyz.cms.model.Customer;
import com.xyz.cms.model.CustomerProduct;
import com.xyz.cms.repository.CustomerProductRepository;

@Service
public class CustomerProductService {
	@Autowired
	private CustomerProductRepository customerProductRepo;
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;
	
	public CustomerProduct addCustomerProduct(CustomerProduct customerProduct) throws CMSException {		
		try {
			customerService.getCustomerById(customerProduct.getCustomerId());
		} catch (CMSException e) {
			e.setErrorCode(HttpStatus.NOT_FOUND.value());
			e.setErrorMessage("error code. Customer not found");
			throw e;
		}
		
		try {
			productService.getProduct(customerProduct.getProductId());
		} catch (CMSException e) {
			e.setErrorCode(HttpStatus.NOT_FOUND.value());
			e.setErrorMessage("error code. Product not found");
			throw e;
		}
		
		return customerProductRepo.save(customerProduct);
	}
	
	public List<CustomerProduct> getProductsByCustomerId(int customerId) throws CMSException {
		try {
			Customer customer = customerService.getCustomerById(customerId);
			
			return customerProductRepo.findByCustomerId(customer.getCustomerId());
		} catch (CMSException e) {
			e.setErrorCode(HttpStatus.NOT_FOUND.value());
			e.setErrorMessage("error code. Customer not found");
			throw e;
		}
	}
}
