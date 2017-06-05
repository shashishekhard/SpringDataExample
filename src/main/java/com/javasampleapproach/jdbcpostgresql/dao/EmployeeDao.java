package com.javasampleapproach.jdbcpostgresql.dao;

import java.util.List;
import com.javasampleapproach.jdbcpostgresql.model.Employee;

public interface EmployeeDao {
	void insert(Employee cus);
	void inserBatch(List<Employee> employees);
	int getTotalNumberCustomer();
}
