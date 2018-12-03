package com.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx =    
				new GenericXmlApplicationContext("classpath:applicationContext.xml",
				                                                  "classpath:applicationContext1.xml"); 
		// 2개 이상 불러오기 가능
		Student student1 = (Student)ctx.getBean("student1"); // 호날두
		System.out.println(student1);
		
		Student student2 = ctx.getBean("student2", Student.class);
		if(student1 == student2) { // 주소비교
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}

		Product product1 = (Product)ctx.getBean("product");
		Product product2 = (Product)ctx.getBean("product");
		
		if(product1 == product2) { // 주소비교
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
	}
}
