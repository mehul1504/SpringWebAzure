package com.nagarro.training.assignment1.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nagarro.training.assignment1.model.Employee;

public interface EmployeeService {

	public Employee findbyId(Integer employeeId);
	public Employee add(Employee employee);
	public ResponseEntity<List<Employee>>find();
	public void deleteById(Integer employeeId);
	public Employee update(Integer employeeId, Employee employeeDetails);
}
