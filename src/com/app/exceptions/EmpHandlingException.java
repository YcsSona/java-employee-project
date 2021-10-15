package com.app.exceptions;

@SuppressWarnings("serial")
public class EmpHandlingException extends Exception {

	// If we leave it as empty it will provide empty string
	public EmpHandlingException(String errMesg) {
		super(errMesg);
	}
}
