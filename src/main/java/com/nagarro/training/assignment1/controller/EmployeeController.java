package com.nagarro.training.assignment1.controller;


import com.nagarro.training.assignment1.ResourceNotFoundException;
import com.nagarro.training.assignment1.model.Employee;
import com.nagarro.training.assignment1.service.EmployeeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService empservice;

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        return empservice.add(employee);
    }


    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return empservice.find();
    }

    @GetMapping("employees/{employeeId}/{name}")
//    @Cacheable(value = "employees",key = "#employeeId")
    public Employee findEmployeeById(@PathVariable(value = "employeeId") Integer employeeId,@PathVariable("name") final String name) {


    	return empservice.findbyId(employeeId);
    }


    @PutMapping("employees/{employeeId}")
//    @CachePut(value = "employees",key = "#employeeId")
    public Employee updateEmployee(@PathVariable(value = "employeeId") Integer employeeId,
                                                   @RequestBody Employee employeeDetails) {

         return empservice.update(employeeId,employeeDetails);
        
    }
    


    @DeleteMapping("employees/{id}")
//    @CacheEvict(value = "employees", allEntries = true)
    public void deleteEmployee(@PathVariable(value = "id") Integer employeeId) {

    	
    	empservice.deleteById(employeeId);
    }
}