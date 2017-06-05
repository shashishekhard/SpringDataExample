package com.javasampleapproach.jdbcpostgresql.service;

import java.util.List;

import com.javasampleapproach.jdbcpostgresql.model.Employee;

public interface EmployeeService {
	void insert(Employee cus);
	void insertBatch(List<Employee> employees);
	void getTotalNumerEmployees();
}
