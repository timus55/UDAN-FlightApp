package com.capgemini.flightmanagement.exception;

public class ExceptionResponse {

	private String errorMessage;
	private String requestedURI;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getrequestedURI() {
		return requestedURI;
	}
	public void setrequestedURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}
	
}
