package com.mary.payroll.EmployeePayrollSystem.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorMessage resourceNotFoundException (ResourceNotFoundException ex, WebRequest webRequest) {
		
		ErrorMessage message =  new ErrorMessage(new Date(),
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),
				webRequest.getDescription(false)
				);
		
				return message;
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage badRequestException (MethodArgumentNotValidException ex, WebRequest webRequest) {
		
		ErrorMessage message =  new ErrorMessage(new Date(),
				HttpStatus.BAD_REQUEST.value(),
				ex.getMessage(),
				webRequest.getDescription(false)
				);
		
		return message;
		
	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage internalServerException (Exception ex, WebRequest webRequest) {
		
		ErrorMessage message =  new ErrorMessage(new Date(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				ex.getMessage(),
				webRequest.getDescription(false)
				);
		
		return message;
		
	}

}
