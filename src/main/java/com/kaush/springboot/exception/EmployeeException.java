package com.kaush.springboot.exception;

public class EmployeeException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EmployeeException(String message) {
		super(message);
	}
	public EmployeeException(Integer id) {
	    super("Could not find employee " + id);
	  }
	
	public EmployeeException() {
		super();
	}
}
