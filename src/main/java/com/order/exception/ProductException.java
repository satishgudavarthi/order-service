package com.order.exception;

public class ProductException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7720452906708542573L;

	public String errorCode;

	public String errorMessage;

	public ProductException(String errorCode, String errorMessage) {
		super(errorCode + "::" + errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
