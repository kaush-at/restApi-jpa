package com.kaush.springboot.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaush.springboot.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
