package com.employee.exception;

public class UserExistsException extends RuntimeException {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	String error;

	public UserExistsException(String error) {
		super(error);
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
