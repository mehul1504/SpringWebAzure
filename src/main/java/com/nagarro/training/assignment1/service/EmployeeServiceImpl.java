package com.nagarro.training.assignment1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.training.assignment1.ResourceNotFoundException;
import com.nagarro.training.assignment1.model.Employee;
import com.nagarro.training.assignment1.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Employee findbyId(Integer employeeId) {
		// TODO Auto-generated method stub
		System.out.println("Employee fetching from database:: "+employeeId);
      return empRepo.findById(employeeId).orElseThrow(
             () -> new ResourceNotFoundException("Employee not found" + employeeId));
		
	}
	@Override
	public Employee add(Employee employee) {
		// TODO Auto-generated method stub
		
		return empRepo.save(employee);
	}
	@Override
	public ResponseEntity<List<Employee>> find(){
		// TODO Auto-generated method stub
		return ResponseEntity.ok(empRepo.findAll());
	}

	public void deleteById(Integer employeeId) {
		// TODO Auto-generated method stub
		Employee employee = empRepo.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found" + employeeId));
       empRepo.delete(employee);
       
	
		
	}

	public Employee update(Integer employeeId, Employee employeeDetails) {
		// TODO Auto-generated method stub
	     Employee employee = empRepo.findById(employeeId)
	        		.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	    employee.setName(employeeDetails.getName());
	    final Employee updatedEmployee= empRepo.save(employee);
	    return updatedEmployee;
	}

	
	
	
	
}
