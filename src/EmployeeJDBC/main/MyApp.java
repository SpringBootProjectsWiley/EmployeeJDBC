package EmployeeJDBC.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import EmployeeJDBC.dao.EmployeeDAO;

public class MyApp {
	public static void main(String args[]) {
		ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		
		EmployeeDAO dao=(EmployeeDAO) context.getBean("edao");
		 int status=dao.saveEmployee(new Employee(102,"Amit",35000));  
		 System.out.println(status);  
	}
}
