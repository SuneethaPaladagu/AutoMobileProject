package com.nisum.controller;


import com.nisum.employee.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class EmployeeMapper implements RowMapper<Employee>{

	   public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		   Employee emp = new Employee();
		   emp.setId(rs.getString("id"));
		   emp.setFname(rs.getString("fname"));
		   emp.setLname(rs.getString("lname"));
	      return emp;
	   }
	}
