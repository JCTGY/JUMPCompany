package com.cognixia.jump.company;



public class EMSDAORunner {

	public static void main(String[] args) {
		EmployeeDAO emp = new EmployeeDAOImpl();
		
		
//		System.out.println(emp.getEmployeeById(2));
//		
//		System.out.println(emp.getAllEmployees());
//		//System.out.println(emp.deleteEmployeebyId(1));
//		
//		Employee dan = new Employee(0, "Daniel Mclain", "Sales", "5555555555", 0);
//		//System.out.println(emp.addEmployee(dan));
//		
//		dan.setSalary(1000000);
//		System.out.println(emp.updateEmployee(dan));
		
		System.out.println(emp.doesEmployeeExist("222222"));
		
		

	}

}
