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
        if(employees != null) {
        	return employees;
        }
        else {
        	throw new EmployeeException("User list is Empty.");
        }
    }
    
    // add new employee
    @PostMapping(value = "/save",consumes = "application/json")
    public Employee saveEmployee(@Valid @RequestBody Employee emp) {
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
    public void updateEmployee(@RequestBody Employee updateEmployee, @PathVariable Integer id) throws EmployeeException {
    	Employee employee = employeeService.findById(id);
    	if(employee != null) {
    		employee.setEmployeeName(updateEmployee.getEmployeeName());
    		employee.setEmployeeAge(updateEmployee.getEmployeeAge());
    		employee.setDepartment(updateEmployee.getDepartment());
    		employeeService.saveEmployee(employee);
    	}
    	else {
    		throw new EmployeeException("User not found.");
    	}
    	
    }
}
