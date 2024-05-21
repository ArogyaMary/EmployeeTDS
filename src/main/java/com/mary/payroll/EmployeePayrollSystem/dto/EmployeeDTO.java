package com.mary.payroll.EmployeePayrollSystem.dto;

import java.util.Date;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class EmployeeDTO {
	
	private Long id;
	
	@NotBlank(message = "First name is mandatory")
	@NotNull(message = "First name cannot be NULL")
	private String firstName;
	
	@NotBlank(message = "Last name is mandatory")
	@NotNull(message = "Last name cannot be NULL")
	private String lastName;
	
	@Email(message = "Please enter a valid email Id")
	@NotBlank(message = "Email is mandatory")
	@NotNull(message = "Email cannot be NULL")
	private String email;
	
	@NotBlank(message = "Phone number is mandatory")
	@NotNull(message = "Phone number cannot be NULL")
	@Pattern(regexp = "^$|^[a-zA-Z0-9\\-\\s.()+]*$", message = "Invalid Phone number")
	private String phoneNumber;
	
	private Date dateOfJoining;
	
	
	@NotNull(message = "Salary cannot be NULL")
	@Min(value = 1, message = "Invalid Salary : Equals to Zero")
	@Max(value = 1000000 , message = "Invalid Salary : Exceeds Salary range")
	private double monthSalary;
	
	
	private int lopDays;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Date getDateOfJoining() {
		return dateOfJoining;
	}


	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}


	public double getMonthSalary() {
		return monthSalary;
	}


	public void setMonthSalary(double monthSalary) {
		this.monthSalary = monthSalary;
	}


	public int getLopDays() {
		return lopDays;
	}


	public void setLopDays(int lopDays) {
		this.lopDays = lopDays;
	}
	
	
	

}
