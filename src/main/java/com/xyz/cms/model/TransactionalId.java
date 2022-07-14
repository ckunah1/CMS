package com.xyz.cms.model;

import java.io.Serializable;
import java.util.Date;

public class TransactionalId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int dateSerial;
	int customerId;
	int productId;
	Date depositDate;

}
