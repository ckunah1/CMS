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
import com.xyz.cms.model.Returns;
import com.xyz.cms.service.ReturnsService;

@RestController
@RequestMapping("/returns")
public class ReturnsController {
	@Autowired
	private ReturnsService returnsService;
	
	ObjectMapper objMapper = new ObjectMapper();
	
	@GetMapping("/get")
	public Returns getReturn(@RequestBody Returns obj) throws JsonProcessingException {
		//Returns temp = 
				return returnsService.getReturnTransaction(obj);
		
	/*	
		try {
			
			return objMapper.writeValueAsString(temp);
		} catch (CMSException e) {
			return e.toString();
		}
		*/
	}
	
	@PostMapping("/make")
	public String makeReturn(@RequestBody Returns returnObj) throws JsonProcessingException {
		try {
			Returns obj = returnsService.makeReturn(returnObj);
			
			return objMapper.writeValueAsString(obj);
		} catch (CMSException e) {
			return e.toString();
		}
	}
}
