package com.example;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.service.UserService;
import com.example.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestApp {
	private Scanner scan;

	@Before
	public void init() {
		this.scan = new Scanner(System.in);
	}
	@Autowired
	UserService userService;
	
	@Test @Ignore
	public void test() {
		//INSERT 
		System.out.print("Enter your userid : ");    String userid = scan.next();
		System.out.print("Enter your name : ");    String name = scan.next();
		System.out.print("Enter your gender : ");    String gender = scan.next();
		System.out.print("Enter your city : ");    String city = scan.next();
		UserVO userVo = new UserVO(userid, name, gender, city);
		this.userService.createUser(userVo);
	}

	@Test @Ignore
	public void test1() {
		//DELETE
		System.out.print("Enter userid to delete : ");  
		String userid = this.scan.next();
		this.userService.deleteUser(userid);
	}
	
	@Test @Ignore
	public void test2() {
		//UPDATE
		System.out.print("Enter userid to update : "); 
		String userid = this.scan.next();
		System.out.print("Enter city name : ");
		String city = this.scan.next();
		this.userService.updateUser(userid, city);
	}
	
	@Test
	public void test3() {
		//All Select
		for(UserVO userVo : this.userService.selectAllUsers()) {
			System.out.println(userVo);
		}
	}
	@Test
	public void test4() {
		//Single Select
		System.out.print("Enter userid to select : ");  
		String userid = this.scan.next();
		UserVO userVo = this.userService.readUser(userid);
		System.out.println(userVo);
	}
}







