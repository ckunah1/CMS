package com.xyz.cms.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.cms.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	public Optional<Transaction> findByCustomerIdAndProductIdAndDateSerialAndDepositDate(int customerId, int productId, int dateSerial, Date depositDate);
	
	public List<Transaction> findByDepositDate(Date depositDate);
}
