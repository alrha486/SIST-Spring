package com.example;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig1 {

	@Bean
	public Student student1() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("독서"); hobbies.add("수영"); hobbies.add("영화감상");
		Student student1 = new Student("호날두",24,hobbies);
		
		student1.setHeight(184.7);
		student1.setWeight(77.6);
		
		return student1;
	}
	
	@Bean
	public StudentInfo StudentInfo() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("독서"); hobbies.add("수영"); hobbies.add("영화감상");
		Student student2 = new Student("호날두",24,hobbies);
		
		student2.setHeight(184.7);
		student2.setWeight(77.6);
		
		StudentInfo studentinfo = new StudentInfo();
		studentinfo.setStudent(student2);
		
		
		return studentinfo;
		
	}
	
}
