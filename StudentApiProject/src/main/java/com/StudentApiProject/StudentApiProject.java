package com.StudentApiProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(value="com.StudentApiProject")
@SpringBootApplication
public class StudentApiProject {

	
		public static void main(String[] args) {
			SpringApplication.run(StudentApiProject.class, args);
		}
	}

