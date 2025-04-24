package com.mary.payroll.EmployeePayrollSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mary.payroll.EmployeePayrollSystem.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	Optional<Employee> findById(Long id);

}
