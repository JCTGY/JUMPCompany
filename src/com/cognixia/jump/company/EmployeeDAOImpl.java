package com.cognixia.jump.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private Connection conn = ConnectionManager.getConnection();

	@Override
	public List<Employee> getAllEmployees() {
		
		ArrayList<Employee> result = new ArrayList<Employee>();
		
		try (PreparedStatement pstmt = conn.prepareStatement("select * from employee");
				ResultSet rs = pstmt.executeQuery(); 
			) {
			
			while(rs.next()) {
				int id = rs.getInt("id_number");
				String name = rs.getString("name");
				String dept = rs.getString("dept_name");
				String number = rs.getString("phone_number");
				int salary = rs.getInt("salary");
				
				Employee emp = new Employee(id, name, dept, number, salary);
				
				result.add(emp);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public Employee getEmployeeById(String employeeId) {
		
		return null;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		
		return false;
	}

	@Override
	public boolean deleteEmployeebyId(String employeeId) {
		
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		
		return false;
	}

	
}
