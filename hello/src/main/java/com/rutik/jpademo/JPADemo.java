package com.rutik.jpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JPADemo {

	public static void main(String[] args) {
		SpringApplication.run(JPADemo.class, args);
	}
}

//when we have jpa we need to specify the url of database
// > application.properties -> spring.datasource.url=(url)
// > application.properties -> spring.jpa.show-sql=true (shows the sql done by jpa)
// > application.properties -> spring.jpa.username=name
//							-> spring.jpa.password=pass