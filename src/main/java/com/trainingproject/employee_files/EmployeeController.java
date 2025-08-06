package com.trainingproject.employee_files;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/readEmployee")
	public List<Employee> getAllDetails() throws SQLException {
		System.out.println("get all details.. api got called!");
		return empService.readAllUsers();
	}
	
}
