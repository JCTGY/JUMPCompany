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
		
		ResultSet rs = null;
		try (PreparedStatement pstmt 
				= conn.prepareStatement("select * from department where name = ?"); 
			) {
			pstmt.setString(1, deptName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				int budget = rs.getInt("budget");
				
				Department dept = new Department(name, phone, budget);
				return dept;
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public boolean addDepartment(Department dept) {
		
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