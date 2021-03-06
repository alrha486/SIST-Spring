package com.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String ConfigXml = "classpath:applicationContext.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(ConfigXml);
		Car car = ctx.getBean("sonata",Sonata.class);
		car.drive();
		car = (HybridSonata)ctx.getBean("hybridCar");
		car.drive();
		ctx.close();
	}
}
