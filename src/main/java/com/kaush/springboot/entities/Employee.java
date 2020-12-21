package com.kaush.springboot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	@Column(name="emp_id")
	private Integer employeeId;
	
	@Size(min = 3, max = 20, message = "Employee name should be min 3 and max 20 charater" )
	@Column(name="emp_name")
	private String employeeName;
	 
	@NotNull
	@Min(value = 18, message = "Age should greater than 18 to legally work in US")
	@Column(name="emp_age")
	private Integer employeeAge;
	
	@NotEmpty(message="Please add the department details")
	private String department;
	
	
	@NotBlank(message = "Email is mandatory")
	@Email
	private String email;
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Integer getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(Integer employeeAge) {
		this.employeeAge = employeeAge;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
