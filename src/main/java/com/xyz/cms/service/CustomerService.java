package com.xyz.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.xyz.cms.exception.CMSException;
import com.xyz.cms.model.Customer;
import com.xyz.cms.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepo;

	public Customer getCustomerById(int customerId) throws CMSException {

		/*	
		Optional<Customer> oCustomer = customerRepo.findById(customerId);//Ask Rahul:is this the correct way for naming variables?

		if(oCustomer.isPresent()) { 
			return oCustomer.get(); 
		} else { 
			throw new CMSException(HttpStatus.NOT_FOUND.value(), "Data cannot be find. Customer does not exist."); 
		}
		*/
		 
		return customerRepo.findById(customerId).orElseThrow(() -> new CMSException(HttpStatus.NOT_FOUND.value(), 
                     "error code. Customer does not exist. The id given is " + customerId));
                     
	}

	public Customer addCustomer(Customer customer) {
		if (customer != null && customer.getCustomerId() > 0) {
			return customerRepo.save(customer);
		}

		return null;
	}

}
