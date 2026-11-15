package com.rutik.jdbctemplate;

import com.rutik.jdbctemplate.employee.Employee;
import com.rutik.jdbctemplate.employee.EmployeeRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TemplateDemo {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TemplateDemo.class, args);

		Employee employee = context.getBean(Employee.class);

		employee.setId(104);
		employee.setName("Nicolas");
		employee.setRole("Production Manager");

		EmployeeRepo repo = context.getBean(EmployeeRepo.class);

		repo.addEmployee(employee);

		System.out.println(repo.getEmployee(101));

		System.out.println(repo.getEmployees());
	}

}
