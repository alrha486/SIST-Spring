package com.example;

public class Calculator {
	public void add(int a, int b) {
		System.out.println("called by add()");
		System.out.println(String.format("%d + %d = %d",a,b,(a+b)));
		}
	public void subtract(int a, int b) {
		System.out.println("called by subtract()");
		System.out.println(String.format("%d - %d = %d",a,b,(a-b)));
		}
	public void multiply(int a, int b) {
		System.out.println("called by multiply()");
		System.out.println(String.format("%d x %d = %d",a,b,(a*b)));
	}
	public void divide(int a, int b) {
		System.out.println("called by divide()");
		System.out.println(String.format("%d / %d = %d",a,b,(a/b)));
	}
}
