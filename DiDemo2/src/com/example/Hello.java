package com.example;


public class Hello {
	private String names;
	private Printer printer;
	
	public Hello(String names, Printer printer) {
		this.names = names;
		this.printer = printer;
	}
	
	public String sayHello(){
		return "Hello " + names;
	}
	
	public void print(){
		this.printer.print(sayHello());
	}

}
