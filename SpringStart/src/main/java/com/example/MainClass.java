package com.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String configXml = "classpath:applicationContext.xml";
		AbstractApplicationContext ctx =new GenericXmlApplicationContext(configXml);
		
		Proxy proxy = ctx.getBean("proxy", Proxy.class);
		proxy.addService();
		proxy.subtractService();
		proxy.multiplyService();
		proxy.divideService();
		
		ctx.close();
	}
}
