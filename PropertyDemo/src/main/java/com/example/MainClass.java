package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
		public static void main(String[] args) {
			GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
			ctx.load("classpath:applicationContext.xml");
			ctx.refresh();
			MydataSource dataSource = ctx.getBean("dataSource",MydataSource.class);
			System.out.println(dataSource);
			ctx.close();	
		}
}
