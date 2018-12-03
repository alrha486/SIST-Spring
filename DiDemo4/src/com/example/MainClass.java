package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class, ApplicationConfig1.class);
		
		Car car = ctx.getBean("sonata",Sonata.class);
		car.drive();
		
		Student student1 = ctx.getBean("student1",Student.class);
		System.out.println(student1);
		
		StudentInfo StudentInfo = ctx.getBean("StudentInfo",StudentInfo.class);
		System.out.println(StudentInfo.getStudent());
		
		
		
		
		
		
	}
}
