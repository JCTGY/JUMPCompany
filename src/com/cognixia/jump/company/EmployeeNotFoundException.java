package com.cognixia.jump.company;

public class EmployeeNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(int employeeId) {
		super("Employee with ID " + employeeId + " was not found." );
	}

}