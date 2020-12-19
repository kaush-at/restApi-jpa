package com.kaush.springboot.services;

import java.util.List;

import com.kaush.springboot.entities.Employee;


public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(Integer id);
	
	Employee saveEmployee(Employee emp);
	
	void deleteEmployee(Integer id);
	
	void deleteAll();

	Employee updateEmployee(Employee emp);
	

}
