package com.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class mainClass {
	public static void main(String[] args) {
		String configXml = "config/beans.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configXml);
		
		Hello hello = ctx.getBean("hello",Hello.class);
		hello.print();
		Printer printer = (StringPrinter)ctx.getBean("StringPriner");
		
		System.out.println(printer.toString());
		
		Hello hello2 = (Hello)ctx.getBean("hello");
		System.out.println(hello);
		System.out.println(hello2);
		
		
/*		Printer printer = new StringPrinter();
		Hello hello = new Hello();
		hello.setName("ÀÌÁø¿õ");
		hello.setPrinter(printer);
		hello.print();
		System.out.println(printer.toString());*/
	}
}
