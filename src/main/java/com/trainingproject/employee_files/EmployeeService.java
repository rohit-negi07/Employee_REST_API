package com.trainingproject.employee_files;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	//getting the connection instance.
		DBConnection dbConnection = DBConnection.getInstance();
		Connection conn = dbConnection.getConnection();

		//--- reading data of employee table
		public List<Employee> readAllUsers() throws SQLException {
			 String q2 = "Select * From employee";

	         Statement stmt = conn.createStatement();

	         ResultSet set = stmt.executeQuery(q2);

	         List<Employee> employee = new ArrayList<>();
	         while(set.next()){
	        	 
	             String accountName = set.getString("accountname");
	             String firstName = set.getString("first_name");
	             String lastName = set.getString("last_name");
	             String email = set.getString("email");
	             Date startDate = set.getDate("start_date");
	             Date endDate = set.getDate("end_date");

	             employee.add(new Employee(accountName, firstName, lastName, email, startDate, endDate));
	             
	         }
	    return employee;
	         
	             
	  }
} 
