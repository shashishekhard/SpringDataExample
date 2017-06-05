package com.javasampleapproach.jdbcpostgresql;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.javasampleapproach.jdbcpostgresql.service.EmployeeService;
import com.javasampleapproach.jdbcpostgresql.model.Employee;

@SpringBootApplication
@ComponentScan("com.javasampleapproach.jdbcpostgresql.service.impl, com.javasampleapproach.jdbcpostgresql.dao.impl")
public class SpringJdbcTemplatePostgreSqlApplication {

	@Autowired
	EmployeeService empService;

	public static void main(String[] args) throws FileNotFoundException {
		ApplicationContext context = SpringApplication.run(SpringJdbcTemplatePostgreSqlApplication.class, args);
		EmployeeService empService = context.getBean(EmployeeService.class);
		
		File file = new File("E:/test.txt");
		Scanner scan = new Scanner(file);
		
		List<Employee> emprepo = new ArrayList<>();
		while(scan.hasNext()){
			String[] data = scan.next().split(",");
			Employee emp = new Employee(Integer.parseInt(data[0]), data[1]);
			emprepo.add(emp);
		}
		scan.close();
		
		empService.insertBatch(emprepo);
		
		empService.getTotalNumerEmployees();
		
		System.out.println("#######################################");
		System.out.println("Done!!!");
		System.out.println("#######################################");
	}
}
