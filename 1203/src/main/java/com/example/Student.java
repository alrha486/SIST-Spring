package com.example;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean{

	private String name;
	private int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	@Override
	public void afterPropertiesSet() throws Exception {	//Bean이 생성될 떄 호출되는 메소드
		System.out.println("Called apferPropertiesSet()");
	}
	
	@Override
	public void destroy() throws Exception { // Bean이 소멸될 떄 호출되는 메소드
		System.out.println("Called Distroy()");
	}
	
}
