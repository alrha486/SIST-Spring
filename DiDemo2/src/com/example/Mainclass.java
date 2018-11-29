package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Mainclass {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("config/beans.xml");
		Hello hello = (Hello)ctx.getBean("hello");
		hello.print();
		Printer printer = (StringPrinter)ctx.getBean("stringPrinter");
		System.out.println(printer.toString());
		/*Printer printer = new StringPrinter();
		Hello hello = new Hello("วัม๖นฮ", printer);
		hello.print();
		System.out.println(printer.toString());*/
	}
}
