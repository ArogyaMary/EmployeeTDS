package com.mary.payroll.EmployeePayrollSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mary.payroll.EmployeePayrollSystem.dto.EmployeeDTO;
import com.mary.payroll.EmployeePayrollSystem.dto.ExtEmployeeDTO;
import com.mary.payroll.EmployeePayrollSystem.model.Employee;
import com.mary.payroll.EmployeePayrollSystem.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody @Valid EmployeeDTO emp) {
		Employee empl = employeeService.addEmployee(emp);
		return new ResponseEntity<>(empl, HttpStatus.CREATED);
	}
	
	@GetMapping("/computeTax/{id}")
	public ResponseEntity<ExtEmployeeDTO> computeTax(@PathVariable Long id){
		try {
		ExtEmployeeDTO emp = employeeService.computeTax(id);
		if(emp.getId() != null)
			return new ResponseEntity<>(emp, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long id){
		EmployeeDTO emp = employeeService.getEmployee(id);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
}
