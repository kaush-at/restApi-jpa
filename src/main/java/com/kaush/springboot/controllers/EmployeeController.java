package com.kaush.springboot.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaush.springboot.entities.Employee;
import com.kaush.springboot.exception.EmployeeException;
import com.kaush.springboot.services.EmployeeService;

@RestController
public class EmployeeController {

	
    @Autowired
    private EmployeeService employeeService;

    // get all employee
    @GetMapping(value = "/employees", consumes = "application/json")
    public List<Employee> getAllEmployees() throws EmployeeException {
        List<Employee> employees = employeeService.findAll();
        if(!employees.isEmpty()) {
        	return employees;
        }
        else {
        	throw new EmployeeException("Employee list is Empty.");
        }
    }
    
    // get Employee by Id
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
    	return employeeService.findById(id);
    }
    
    // add new employee
    @PostMapping(value = "/save",consumes = "application/json")
    public Employee saveEmployee(@RequestBody @Valid Employee emp) {
    	return employeeService.saveEmployee(emp);
    }
    
    // delete employee by id
    @DeleteMapping("/delete/{id}")
    public void deleteEmployeeById(@PathVariable Integer id) {
    	employeeService.deleteEmployee(id);
    }
    
    // delete all employee
    @DeleteMapping("/delete")
    public void deleteAllEmplees() {
    	employeeService.deleteAll();
    }
    
    // update employee
    @PutMapping(path="/update/{id}", consumes="application/json")
    public Employee updateEmployee(@RequestBody Employee emp, @PathVariable Integer id) throws EmployeeException {
    	Employee employeeFoundById = employeeService.findById(emp.getEmployeeId());
    	
		if(employeeFoundById != null) {
			if(emp.getEmployeeName() != null) {
				employeeFoundById.setEmployeeName(emp.getEmployeeName());
			}
			if(emp.getEmployeeAge() != null) {
				employeeFoundById.setEmployeeAge(emp.getEmployeeAge());
			}
			if(emp.getDepartment() != null) {
				employeeFoundById.setDepartment(emp.getDepartment());
			}
			if(emp.getEmail() != null) {
				employeeFoundById.setEmail(emp.getEmail());
			}
			
			return employeeService.updateEmployee(emp);			
		}else {
			throw new EmployeeException("Employee not found for given Id");
		}
    }
    
}
