package com.javasampleapproach.jdbcpostgresql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.jdbcpostgresql.dao.EmployeeDao;
import com.javasampleapproach.jdbcpostgresql.model.Employee;
import com.javasampleapproach.jdbcpostgresql.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired EmployeeDao employeeDao;
	
	@Override
	public void insert(Employee cus) {
		employeeDao.insert(cus);
	}
	
	@Override
	public void insertBatch(List<Employee> employees) {
		employeeDao.inserBatch(employees);
	}	

	@Override
	public void getTotalNumerEmployees() {
		int totalNumberCustomer = employeeDao.getTotalNumberCustomer();
		System.out.println("Total Number Employees is: " + totalNumberCustomer);
	}
}
