package com.cognixia.jump.advancedjava.finalproject;

import java.util.List;

public interface EmployeeDAO {

	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(String employeeId);
	
	public boolean addEmployee(Employee employee);
	
	public boolean deleteEmployeebyId(String employeeId);
	
	public boolean updateEmployee(Employee employee);

}
