package com.kaush.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaush.springboot.entities.Employee;
import com.kaush.springboot.repos.EmployeeRepo;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	EmployeeRepo employeeRepo;
	
	
	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee findById(Integer id) {
		return employeeRepo.findById(id).get();
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		Employee savedEmp = employeeRepo.save(emp);
		return savedEmp;
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepo.deleteById(id);
	}

	@Override
	public void deleteAll() {
		employeeRepo.deleteAll();
	}

	@Override
	public void updateEmployee(Employee emp) {
		Employee findById = employeeRepo.findById(emp.getEmployeeId()).get();
		if(findById != null) {
			employeeRepo.save(emp);			
		}else {
			
		}
	}
	
	
}
