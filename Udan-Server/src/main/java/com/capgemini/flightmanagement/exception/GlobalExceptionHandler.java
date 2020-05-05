package com.capgemini.flightmanagement.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author  Sumeet Patil
 *			This class handels Global Exceptions occured in the all the levels.
 *			Classes annotated with {@code @ControllerAdvice} can be declared explicitly
 * 			as Spring beans or auto-detected via classpath scanning.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Annotation for handling exceptions in specific handler classes and/or
	 * handler methods.
	 * @param exception
	 * @param request
	 * @return ResponseBody
	 */
	
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