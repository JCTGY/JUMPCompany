package com.cognixia.jump.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class ConnectionManager {

	private static Connection connection;
	
	
	private static void makeConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Register Driver");
			
			Properties props = new Properties();
			props.load(new FileInputStream("resources/config.properties"));
			String URL = props.getProperty("URL");
			String USER_NAME = props.getProperty("USER_NAME");
			String PASSWORD = props.getProperty("PASSWORD");
			
			connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("Connecting");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {

		if (connection == null)
			makeConnection();
		return connection;
	}
	
	public static void main(String[] args) {
		try (Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select first_name, last_name, "
						+ "TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) AS age "
						+ "from student;")) {
			while (rs.next()) {
				String name = rs.getString("first_name") + " " + rs.getString("last_name");
				int age = rs.getInt("age");
				System.out.println("Student: " + name + " || Age: " + age);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
