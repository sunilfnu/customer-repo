package com.example.apex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * The Challenge
This challenge with have you build REST APIs to build the CRUD Operations for a 
 a Simple Customer Management System using Spring Boot 2, JPA and H2 database.  
We will build the REST APIs with Spring and also use JPA, Hibernate, 
and an H2 Embedded Database.   The Application should be build with Java 8 or
 higher and Spring Boot 2.0 or higher.
You will need an IDE to build the application,
 IntelliJ is preferred but you can use another if you already have one on your machine. 
You can download a trial version of IntelliJ at:
https://www.jetbrains.com/idea/download/#section=windows 
You can choose if you want to create the project with Maven or Gradle.
The API should support versioning and the resource should be customer.

 *
 */
@SpringBootApplication
public class ApexApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApexApplication.class, args);
	}

}
