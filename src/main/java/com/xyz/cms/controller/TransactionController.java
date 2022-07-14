package com.xyz.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyz.cms.exception.CMSException;
import com.xyz.cms.model.Transaction;
import com.xyz.cms.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	ObjectMapper objMapper = new ObjectMapper();

	@GetMapping("/get")
	public String getTransaction(@RequestBody Transaction transaction) throws JsonProcessingException {
		Transaction transactionObj;
		
		try {
			//test getTransaction
			transactionObj = transactionService.getTransaction(transaction.getCustomerId(), transaction.getProductId(), transaction.getDateSerial(), transaction.getDepositDate());
		} catch (CMSException e) {
			return e.getErrorCode() + e.getErrorMessage();
		}
		
		return objMapper.writeValueAsString(transactionObj);
	}

	@PostMapping("/add")
	public String addTransaction(@RequestBody Transaction transaction) throws JsonProcessingException {
		Transaction transactionObj;
		
		try {
			transactionObj = transactionService.addTransaction(transaction);
		} catch (CMSException e) {
			return e.getErrorCode() + e.getErrorMessage();
		}
		
		return objMapper.writeValueAsString(transactionObj);
	}
}
