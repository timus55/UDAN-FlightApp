package com.capgemini.flightmanagement.exception;

public class EntityNotFound extends RuntimeException{
	public EntityNotFound(String message) {
		super("Something went Wrong ..!\n "+ message);
	}
}

