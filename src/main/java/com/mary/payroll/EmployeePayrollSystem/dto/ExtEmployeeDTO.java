package com.mary.payroll.EmployeePayrollSystem.dto;

public class ExtEmployeeDTO extends EmployeeDTO {
	
	private double yearSalary;
	
	private double taxAmount;
	
	private double cessCharge;
	
	private double lop;
	
	public double getYearSalary() {
		return yearSalary;
	}
	
	public void setYearSalary(double yearSalary) {
		this.yearSalary = yearSalary;
	}
	
	public double getTaxAmount() {
		return taxAmount;
	}
	
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	
	public double getCessCharge() {
		return cessCharge;
	}
	
	public void setCessCharge(double cessCharge) {
		this.cessCharge = cessCharge;
	}

	public double getLop() {
		return lop;
	}

	public void setLop(double lop) {
		this.lop = lop;
	}
	
	
	

}
