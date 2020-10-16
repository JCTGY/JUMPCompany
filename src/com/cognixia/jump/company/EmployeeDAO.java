package com.cognixia.jump.company;

import java.util.List;

public interface EmployeeDAO {

	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int employeeId);
	
	public boolean addEmployee(Employee employee);
	
	public boolean deleteEmployeebyId(int employeeId);
	
	public boolean updateEmployee(Employee employee);

}
