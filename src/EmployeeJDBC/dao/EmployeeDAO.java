package EmployeeJDBC.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import EmployeeJDBC.main.Employee;

public class EmployeeDAO {
	private JdbcTemplate JDBCTemplate;

	public void setJDBCTemplate(JdbcTemplate jDBCTemplate) {
		JDBCTemplate = jDBCTemplate;
	}
	
	public int saveEmployee(Employee emp) {
		String name=emp.getName();
		String query="INSERT INTO employee (" +
				"id, name,salary" +
				") VALUES (" +
				"?, ?,?" +
				")";
		
		return JDBCTemplate.update(query,emp.getId(),emp.getName(),emp.getSalary());
	}
	public int updateEmployee(Employee emp) {
		String query=String.format("update employee set name=%s,salary=%d where id=%d;", emp.getName(),emp.getSalary(),emp.getId());
		
		return JDBCTemplate.update(query);
	}
	public int deleteEmployee(Employee emp) {
		String query=String.format("delete from employee where id=%d;", emp.getId());
		
		return JDBCTemplate.update(query);
	}
}
