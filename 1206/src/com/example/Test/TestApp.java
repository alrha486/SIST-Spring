package com.example.Test;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.DAO.EmployeeDAO;
import com.example.VO.EmployeeVO;

public class TestApp {
	private ApplicationContext ctx;
	
	@Before
	public void init() {
		this.ctx = new GenericXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void test2() { // selectAll
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter id to Select : ");
		int id = scan.nextInt();
		EmployeeDAO dao = this.ctx.getBean("EmployeeDAO",EmployeeDAO.class);
		System.out.println(dao.read(id));
	}
	
	
	@Test @Ignore
	public void test1() { // selectAll
		EmployeeDAO dao = this.ctx.getBean("EmployeeDAO",EmployeeDAO.class);
		for(EmployeeVO employeeVo : dao.readAll()) {
			System.out.println(employeeVo);
		}
	}
	@Test @Ignore
	public void test() { //insert
		EmployeeDAO dao = this.ctx.getBean("EmployeeDAO",EmployeeDAO.class);
		Boolean flag = dao.insert(new EmployeeVO(3,"È£³¯µÎ",25000000));
		System.out.println(flag.booleanValue() ? "insert success" : "insert failure");
	}


}
