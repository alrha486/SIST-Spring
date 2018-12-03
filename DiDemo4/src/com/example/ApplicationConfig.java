package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public Sonata sonata() { // 메소드 이름 = bean's id
		Sonata sonata = new Sonata();
		return sonata;
	}
	
	@Bean
	public Carnival carnival() { // 메소드 이름 = bean's id
		Carnival carnival = new Carnival();
		return carnival;
	}

}
