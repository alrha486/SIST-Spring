package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public Sonata sonata() { // �޼ҵ� �̸� = bean's id
		Sonata sonata = new Sonata();
		return sonata;
	}
	
	@Bean
	public Carnival carnival() { // �޼ҵ� �̸� = bean's id
		Carnival carnival = new Carnival();
		return carnival;
	}

}
