package com.cognixia.jump.company;

public class Employee {
	int id;
	public String name;
	public String departmentName;
	public String number;
	public int salary;

	public Employee(int id, String name, String departmentName, String number, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.departmentName = departmentName;
		this.number = number;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
	   this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


 
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}


	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee id=" + id + "\n name=" + name + "\n departmentName=" + departmentName + "\n number=" + number + "\n salary=" + salary + "\n\n";
	}
	
}
