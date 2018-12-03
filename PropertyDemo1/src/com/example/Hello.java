package com.example;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hello")
public class Hello {
	
	@Value("${myname}")
	private String name;
	
	@Resource(name="${myprinter}")
	private Printer printer;
	
	@Value("${value1},${value2},${value3},${value4}")
	private List<String> names;

	
	
	public List<String> getNames() {
		return this.names;
	}

	public Hello() {}
	
	public void setNames(List<String> names) {
		this.names = names;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public String sayHello(){
		return "Hello " + name;
	}
	
	public void print(){
		this.printer.print(sayHello());
	}
}
