package com.capgemini.flightmanagement.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(EntityNotFound.class)
//	@ResponseStatus(value = HttpStatus.NOT_FOUND)
//	public ResponseEntity<Object> myMessage(EntityNotFound m){
//		return new ResponseEntity<Object>(m.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@ExceptionHandler(EntityNotFound.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ExceptionResponse handleAccountExits(EntityNotFound exception,
			HttpServletRequest request) {
		
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.setrequestedURI(request.getRequestURI());
		return error;
	}
}