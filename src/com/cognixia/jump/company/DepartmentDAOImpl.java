package com.cognixia.jump.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO{
	
	private Connection conn = ConnectionManager.getConnection();

	@Override
	public List<Department> getAllDepartments() {
		
		ArrayList<Department> result = new ArrayList<Department>();
		
		try (PreparedStatement pstmt = conn.prepareStatement("select * from department");
				ResultSet rs = pstmt.executeQuery(); 
			) {
			
			while (rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				int budget = rs.getInt("budget");
				
				Department dept = new Department(name, phone, budget);
				
				result.add(dept);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public Department getDepartmentByName(String deptName) {
		
		
		return null;
	}

	@Override
	public boolean addDepartment(Department dept) {
		
		try(PreparedStatement pstmt = conn.prepareStatement("insert into department values(?,?,?)")) {
			
			pstmt.setString(1, dept.getName());
			pstmt.setString(2, dept.getPhoneNumber());
			pstmt.setInt(3, dept.getBudget());
			
			int count = pstmt.executeUpdate();
			
			if (count > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	public boolean deleteDepartmentByName(String deptName) {
		
		return false;
	}

	@Override
	public boolean updateDepartment(Department dept) {
		
		return false;
	}

	

}
