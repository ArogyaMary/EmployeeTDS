package com.mary.payroll.EmployeePayrollSystem.model;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "employee")

@Getter
@Setter
@EqualsAndHashCode
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (name = "first_name", nullable = false)
	private String firstName;
	
	@Column (name = "last_name", nullable = false)
	private String lastName;
	
	@Column (name = "email", nullable = false)
	private String email;
	
	@Column (name = "phone_number", nullable = false)
	private String phoneNumber;
	
	@Column (name = "DOJ", nullable = false)
	private Date dateOfJoining;
	
	@Column (name = "month_salary", nullable = false)
	private double monthSalary;
	
	@Column (name = "lop_days", nullable = false)
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

	@Override
	public int hashCode() {
		return Objects.hash(dateOfJoining, email, firstName, id, lastName, lopDays, monthSalary, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dateOfJoining, other.dateOfJoining) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && lopDays == other.lopDays
				&& Double.doubleToLongBits(monthSalary) == Double.doubleToLongBits(other.monthSalary)
				&& Objects.equals(phoneNumber, other.phoneNumber);
	}
	
	
	
	
	
	
}
