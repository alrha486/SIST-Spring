package com.example;

import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.service.UserService;
import com.oracle.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")

public class TestApp {
	@Autowired
	private UserService userService;
	
	@Test @Ignore
	public void test_delete() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제하고싶은 id는? : "); 
		String userid1= scan.next();
		this.userService.deleteUser(userid1);
	}
	
	@Test 
	public void test1() {
		for(UserVO uservo : this.userService.selectAllUser()) {
			System.out.println(uservo);
		}
	}
	
	@Test @Ignore
	public void test() {
		Scanner scan = new Scanner(System.in);
		System.out.print("UserId : "); String userid = scan.next();
		System.out.print("UserNAme : "); String name = scan.next();
		System.out.print("UserGender : "); String gender = scan.next();
		System.out.print("UserCity : "); String city = scan.next();
		UserVO uservo = new UserVO(userid,name,gender,city);
		this.userService.createUser(uservo);
		
	}

}
