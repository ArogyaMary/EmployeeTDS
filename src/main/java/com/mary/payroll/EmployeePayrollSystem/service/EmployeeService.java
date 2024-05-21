package com.mary.payroll.EmployeePayrollSystem.service;

import java.util.List;

import com.mary.payroll.EmployeePayrollSystem.dto.EmployeeDTO;
import com.mary.payroll.EmployeePayrollSystem.dto.ExtEmployeeDTO;
import com.mary.payroll.EmployeePayrollSystem.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(Long id);
	
	public Employee addEmployee(EmployeeDTO employee);
	
	public Employee updateEmployee(Long id, EmployeeDTO employee);
	
	public ExtEmployeeDTO computeTax(Long id);
	
	public EmployeeDTO getEmployee(Long id);
	
}
