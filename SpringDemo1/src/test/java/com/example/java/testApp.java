package com.example.java;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.Student;
import com.example.StudentInfo;

public class testApp {
	private ApplicationContext ctx;
	
	@Before
	public void init() {
		this.ctx= new GenericXmlApplicationContext("classpath:applicationContext.xml");
	}

	@Test
	public void test() {
		assertNotNull(this.ctx);	
	}
	
	@Test
	public void test1() {
		Student student1 = (Student)this.ctx.getBean("student1");
/*		Student student2 = (Student)this.ctx.getBean("student2");*/
		StudentInfo info = (StudentInfo)this.ctx.getBean("studentInfo");
		info.printInfo();
	}

}
