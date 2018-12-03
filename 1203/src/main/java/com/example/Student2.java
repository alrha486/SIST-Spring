package com.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Student2{

	private String name;
	private int age;

	public Student2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	@PostConstruct
	public void initMethod() throws Exception {	//Bean이 생성될 떄 호출되는 메소드
		System.out.println("Called apferPropertiesSet()");
	}
	
	@PreDestroy
	public void destroyMethod() throws Exception { // Bean이 소멸될 떄 호출되는 메소드
		System.out.println("Called Distroy()");
	}
	
}
