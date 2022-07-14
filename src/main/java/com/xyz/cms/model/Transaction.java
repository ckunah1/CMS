package com.xyz.cms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "transaction_table")
@IdClass(TransactionalId.class)
public class Transaction {
	@Id
	int customerId;
	@Id
	int productId;
	@Id
	@JsonFormat(pattern="yyyy-MM-dd")
	Date depositDate;
	@Id
	int dateSerial;
	
	Date payout;
	double amount;
	boolean status;
	String remarks;
}
