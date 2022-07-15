package com.xyz.cms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.cms.model.CustomerProduct;
import com.xyz.cms.model.Returns;
import com.xyz.cms.model.Transaction;
import com.xyz.cms.repository.CustomerProductRepository;
import com.xyz.cms.repository.ReturnsRepository;
import com.xyz.cms.repository.TransactionRepository;

@Service
public class OtherService {
	@Autowired
	private ReturnsRepository returnsRepo;

	@Autowired
	private TransactionRepository transactionRepo;

	@Autowired
	private CustomerProductRepository custProductRepo;

	public int getAmountPosted(Transaction transaction) {
		int amountPosted = 0;
		int amountPaid = 0;
		int amountReturned = 0;
		
		List<Transaction> transactionList = transactionRepo.findByCustomerIdAndProductId(transaction.getCustomerId(),
				transaction.getProductId());

		List<Returns> returnsList = returnsRepo.findByCustomerIdAndProductId(transaction.getCustomerId(),
				transaction.getProductId());
		
		for(Transaction obj : transactionList) {
			amountPaid += obj.getAmount();
		}
		
		for(Returns obj : returnsList) {
			amountReturned += obj.getAmount();
		}
		
		amountPosted = amountPaid - amountReturned;
		
		return amountPosted;
	}
	
	Map<Integer/*Arrangement*/, List<CustomerProduct>> payoutDetailsMapList = new HashMap<>();
	List<CustomerProduct> custProductList = new ArrayList<>();
	
	public int getAmountPosted(CustomerProduct custProduct) {
		int amountPosted = 0;
		int amountPaid = 0;
		int amountReturned = 0;
		
		custProductList.addAll(custProductRepo.findByCustomerIdAndProductId(custProduct.getCustomerId(), custProduct.getProductId()));
		
		
		
		List<Transaction> transactionList = transactionRepo.findByCustomerIdAndProductId(transaction.getCustomerId(),
				transaction.getProductId());

		List<Returns> returnsList = returnsRepo.findByCustomerIdAndProductId(transaction.getCustomerId(),
				transaction.getProductId());
		
		for(Transaction obj : transactionList) {
			amountPaid += obj.getAmount();
		}
		
		for(Returns obj : returnsList) {
			amountReturned += obj.getAmount();
		}
		
		amountPosted = amountPaid - amountReturned;
		
		return amountPosted;
	}
	
}
