package com.example;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String choice = selectDb();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(choice);
		ctx.load("classpath:oracle.xml", "classpath:mariadb.xml");
		ctx.refresh();

		ServerInfo serverInfo = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println(serverInfo);
		
		ctx.close();
	}
	public static String selectDb() {
		Scanner scan = new Scanner(System.in);
		System.out.println("oracle or mariadb");
		System.out.print("어떤 Database를 사용하시겠습니까 ? : ");
		return scan.next();
	}
}
