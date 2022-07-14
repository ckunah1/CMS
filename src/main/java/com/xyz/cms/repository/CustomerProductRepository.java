package com.xyz.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.cms.model.CustomerProduct;

public interface CustomerProductRepository extends JpaRepository<CustomerProduct, Integer>{
	public List<CustomerProduct> findByCustomerId(int customerId);
}