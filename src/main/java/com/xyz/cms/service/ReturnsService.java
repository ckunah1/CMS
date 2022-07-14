package com.xyz.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.xyz.cms.exception.CMSException;
import com.xyz.cms.model.Returns;
import com.xyz.cms.repository.ReturnsRepository;

@Service
public class ReturnsService {
	@Autowired
	private ReturnsRepository returnsRepo;

	public Returns getReturnTransaction(Returns obj) throws CMSException {
		return returnsRepo
				.findByCustomerIdAndProductIdAndAmount(obj.getCustomerId(), obj.getProductId(), obj.getAmount())
				.orElseThrow(() -> new CMSException(HttpStatus.NOT_FOUND.value(), "Transaction not found."));
	}

	public Returns makeReturn(Returns returnObj) throws CMSException {
		if (returnObj != null && returnObj.getCustomerId() > 0 && returnObj.getProductId() > 0
				&& returnObj.getAmount() > 0) {
			return returnsRepo.save(returnObj);
		}

		throw new CMSException(HttpStatus.NOT_ACCEPTABLE.value(), "Unacceptable values given.");
	}

}
