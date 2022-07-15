package com.xyz.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.cms.model.Returns;
import com.xyz.cms.model.Transaction;
import com.xyz.cms.service.OtherService;
import com.xyz.cms.service.ReturnsService;
import com.xyz.cms.service.TransactionService;

@RestController
@RequestMapping("/other")
public class OtherController {
	@Autowired
	private OtherService otherService;
	
	@GetMapping("/owed")
	public int getMapping (@RequestBody Transaction objTransaction) {
		return otherService.getAmountPosted(objTransaction);
	}
	
}
