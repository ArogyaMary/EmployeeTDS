package com.mary.payroll.EmployeePayrollSystem.exception;

import java.util.Date;

public class ErrorMessage {

	private Date timestamp;
	
	private int statusCode;
	
	private String message;
	
	private String description;
	
	

	public ErrorMessage(Date timestamp, int statusCode, String message, String description) {
		super();
		this.timestamp = timestamp;
		this.statusCode = statusCode;
		this.message = message;
		this.description = description;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
