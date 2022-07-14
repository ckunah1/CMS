package com.xyz.cms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "customer")
public class Customer {
	@Id
	//@Column(name = "customerId")
	int customerId;
	String custName;
	String description;
	String email;
	boolean isActive;
}
