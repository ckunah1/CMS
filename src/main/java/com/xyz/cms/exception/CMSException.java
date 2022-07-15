package com.xyz.cms.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CMSException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2443778652015015442L;
	int errorCode;
	String errorMessage;
	
	public CMSException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public CMSException(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}	
	
	public String toString() {
		String returnString = new String();
		if (errorCode != 0) {
			returnString += String.valueOf(errorCode) + " error code. ";
		}
		
		if (errorMessage != null) {
			returnString += errorMessage;
		}
		
		return returnString;
	}
}
