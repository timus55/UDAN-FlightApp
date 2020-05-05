package com.capgemini.flightmanagement.exception;

public class EntityNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EntityNotFound(String message) {
		super("Something went Wrong ..!\n "+ message);
	}
}

