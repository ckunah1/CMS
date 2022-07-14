package com.xyz.cms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "customerproduct")
@IdClass(CustomerProductId.class)
public class CustomerProduct {
	@Id
	int customerId;
	@Id
	int productId;
	int arrangement;
	double limitVar;
	double outstanding;
}
