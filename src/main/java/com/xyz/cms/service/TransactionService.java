package com.xyz.cms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.xyz.cms.exception.CMSException;
import com.xyz.cms.model.Transaction;
import com.xyz.cms.repository.TransactionRepository;

import lombok.Getter;

@Service
@Getter
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepo;

	List<Transaction> transactionsByDate;

	public Transaction getTransaction(int customerId, int productId, int dateSerial, Date date) throws CMSException {
		return transactionRepo.findByCustomerIdAndProductIdAndDateSerialAndDepositDate(customerId, productId, dateSerial, date)
				.orElseThrow(
						() -> new CMSException(HttpStatus.NOT_FOUND.value(), " error code. Transaction not found."));
	}

	public Transaction addTransaction(Transaction transaction) throws CMSException {
		int dateSerialVar = 1;
		transactionsByDate = transactionRepo.findByDepositDate(transaction.getDepositDate());
		
		for (Transaction obj : transactionsByDate) {
			if (obj.getDateSerial() >= dateSerialVar) {
				dateSerialVar = obj.getDateSerial();
				dateSerialVar++;
			}
		}
		
		
		transaction.setDateSerial(dateSerialVar);
		
		if (transaction != null && transaction.getCustomerId() > 0 && transaction.getProductId() > 0
				&& transaction.getDateSerial() > 0) {
			return transactionRepo.save(transaction);
		}

		throw new CMSException(HttpStatus.NOT_ACCEPTABLE.value(), " error code. Incorrect submission.");
	}
}
