package com.xyz.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.cms.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
