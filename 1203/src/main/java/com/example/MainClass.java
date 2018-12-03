package com.example;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationContext.xml");
		ctx.refresh(); // 빈 생성
		Student2 student2 = ctx.getBean("student2",Student2.class);
		System.out.println(student2);
		
		ctx.close(); // 빈 제거
		
	}
}
