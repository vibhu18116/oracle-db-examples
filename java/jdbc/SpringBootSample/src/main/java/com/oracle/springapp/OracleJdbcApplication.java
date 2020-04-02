package com.oracle.springapp;


import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oracle.springapp.model.Employee;
import com.oracle.springapp.service.EmployeeService;

/**
 * SpringBoot application main class. It uses JdbcTemplate class which
 * internally uses UCP for connection check-outs and check-ins.
 *
 */
@SpringBootApplication
public class OracleJdbcApplication implements CommandLineRunner {

    @Autowired
    EmployeeService employeeService;
    
	public static void main(String[] args) {
		SpringApplication.run(OracleJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeService.displayTableNames();
		System.out.println("List of employees");
		employeeService.displayEmployees();
		employeeService.insertEmployee(new Employee(7954,"TAYLOR","MANAGER",7839, Date.valueOf("2020-03-20"),5300,0,10));
		System.out.println("List of Employees after the update");
		employeeService.displayEmployees();		
	}

}
