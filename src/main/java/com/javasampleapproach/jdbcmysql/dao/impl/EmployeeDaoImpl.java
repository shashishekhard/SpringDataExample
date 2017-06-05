package com.javasampleapproach.jdbcpostgresql.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.jdbcpostgresql.dao.EmployeeDao;
import com.javasampleapproach.jdbcpostgresql.model.Employee;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public void insert(Employee cus) {
		String sql = "INSERT INTO customer " +
				"(ID, NAME) VALUES (?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				cus.getId(), cus.getName()
		});
	}
	
	@Override
	public int getTotalNumberCustomer() {
		String sql = "SELECT Count(*) FROM employee";
		int total = getJdbcTemplate().queryForObject(sql, Integer.class);
		return total;
	}

	@Override
	public void inserBatch(List<Employee> employees) {
		String sql = "INSERT INTO employee " + "(id, NAME) VALUES (?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Employee customer = employees.get(i);
				ps.setLong(1, customer.getId());
				ps.setString(2, customer.getName());
			}
			
			public int getBatchSize() {
				return employees.size();
			}
		});
	}

	
}

