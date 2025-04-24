package com.mary.payroll.EmployeePayrollSystem.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

import com.mary.payroll.EmployeePayrollSystem.dto.EmployeeDTO;
import com.mary.payroll.EmployeePayrollSystem.dto.ExtEmployeeDTO;
import com.mary.payroll.EmployeePayrollSystem.exception.ResourceNotFoundException;
import com.mary.payroll.EmployeePayrollSystem.model.Employee;
import com.mary.payroll.EmployeePayrollSystem.repository.EmployeeRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
    @Autowired
    private ModelMapper modelMapper;

	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not found"));
	}

	@Override
	public EmployeeDTO getEmployee(Long id) {
		Employee emp = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not found"));
		EmployeeDTO empDTO = null;
		try {
			empDTO = convertToDTO(emp);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return empDTO;
	}
	@Override
	public Employee addEmployee(EmployeeDTO employee) {
		// TODO Auto-generated method stub
		Employee emp =  convertToEntity(employee);
		return employeeRepository.save(emp);
	}

	@Override
	public Employee updateEmployee(Long id, EmployeeDTO employee) {
		// TODO Auto-generated method stub
		Employee emp = getEmployeeById(id);
		emp.setFirstName(employee.getFirstName()!=null ? employee.getFirstName() : employee.getFirstName());
		emp.setLastName(employee.getLastName()!=null ? employee.getLastName() : employee.getLastName());
		emp.setEmail(employee.getEmail()!= null ? employee.getEmail() : employee.getEmail());
		emp.setDateOfJoining(employee.getDateOfJoining()!= null ? employee.getDateOfJoining() : employee.getDateOfJoining());
		emp.setLopDays(employee.getLopDays() != 0 ? employee.getLopDays() : employee.getLopDays());
		emp.setMonthSalary(employee.getMonthSalary() != 0.0 ? employee.getMonthSalary() : employee.getMonthSalary());
		emp.setPhoneNumber(employee.getPhoneNumber() != null ? employee.getPhoneNumber() : employee.getPhoneNumber());
		
		return employeeRepository.save(emp);
	}
	
	@Override
	public ExtEmployeeDTO computeTax(Long id) {
		ExtEmployeeDTO empDTO = new ExtEmployeeDTO();
		try {
			Employee emp = getEmployeeById(id);
			String date_string = "2024-03-31"; 
			String date1_string = "2023-04-01";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
			Date date = parseDate(date_string);
			Date date1 = parseDate(date1_string);
			Long days = calculateDays(date, date1 , emp.getDateOfJoining());
			double income = emp.getMonthSalary()*12;
			double daySal = emp.getMonthSalary()/30;
			double netIncome = 0;
			if(days > 0) {
				netIncome = (days * daySal);
			}
			double tax = calculateTax(netIncome);
			double cess = calculateCess(netIncome);
			 
			empDTO.setId(emp.getId());
			empDTO.setFirstName(emp.getFirstName());
			empDTO.setLastName(emp.getLastName());
			empDTO.setDateOfJoining(emp.getDateOfJoining());
			empDTO.setLopDays(emp.getLopDays());
			empDTO.setEmail(emp.getEmail());
			empDTO.setPhoneNumber(emp.getPhoneNumber());
			empDTO.setYearSalary(income);
			empDTO.setTaxAmount(tax);
			empDTO.setCessCharge(cess);
			empDTO.setLop(emp.getLopDays()* daySal);
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	         
        return empDTO;
		
 }
	
	public double calculateTax(double income) {
		double tax = 0;
        double appIncome = 0;
        if (income <= 250000) {
            tax = 0;
        } else if (income >= 250001 && income <= 500000) {
            appIncome = income - 250000;
            tax = 0.05 * appIncome;
        } else if (income >= 500001 && income <= 1000000) {
            appIncome = income - 500000;
            //0.05*250000 = 12500 is the tax for the 250000 slab
            tax = 12500 + (0.10 * appIncome);
        } else { // income > 1000000
            appIncome = income - 1000000;
            //(0.05*250000 )+ (0.10*500000) taxes of 250000 and 500000 slabs
            tax = 62500 + (0.20 * appIncome);
        }
        
        return tax;
	}
	
	public double calculateCess(double income) {
		 double cess = 0;
	     if(income > 2500000) {
	        	cess = 0.02 * (income - 2500000);
	      }
	     return cess;
		
	}

	
	private Employee convertToEntity(EmployeeDTO employeeDTO) throws ParseException {
	    Employee emp = modelMapper.map(employeeDTO, Employee.class);
	    return emp;
	}
	
	private EmployeeDTO convertToDTO(Employee employee) throws ParseException {
	    EmployeeDTO emp = modelMapper.map(employee, EmployeeDTO.class);
	    return emp;
	}
	
	public Long differenceBetweenDates(Date date1, Date date2) {
		long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		return diff;
		
	}
	
	public Date parseDate(String date_string) {
		Date date = null;
		try {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		date = formatter.parse(date_string); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return date;
		
	}
	
	public Long calculateDays(Date d1, Date d2, Date doj) {
		Long days = 0L;
			if(doj.before(d2))
				days = differenceBetweenDates(d2, d1);
			else
				days = differenceBetweenDates(doj, d1);
			
		    return days;
		}

}