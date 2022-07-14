package com.xyz.cms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "product")
public class Product {
	@Id
	int productId;
	String productName;
	double price;
	double nlt;
	double otc;
}
