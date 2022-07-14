package com.xyz.cms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.cms.model.Returns;

public interface ReturnsRepository extends JpaRepository<Returns, Integer>{
	public Optional<Returns> findByCustomerIdAndProductIdAndAmount(int customerId, int productId, double amount);
}
