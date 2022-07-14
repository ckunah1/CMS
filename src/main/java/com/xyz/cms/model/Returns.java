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
@Table(name = "returns_table")
@IdClass(ReturnsID.class)
public class Returns {
	//should have unique return id;
	@Id
	int customerId;
	@Id
	int productId;
	double amount;
	String remarks;
}
