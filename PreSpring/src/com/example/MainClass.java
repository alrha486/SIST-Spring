package com.example;

public class MainClass {
	public static void main(String[] args) {
		Proxy proxy = new Proxy();
		Calculator calc = new Calculator();
		proxy.setCalculater(calc);
		proxy.setFirstNum(9);
		proxy.setSecondNum(5);
		proxy.addService();
		proxy.subtractService();
		proxy.multiplyService();
		proxy.divideService();
	}
}
