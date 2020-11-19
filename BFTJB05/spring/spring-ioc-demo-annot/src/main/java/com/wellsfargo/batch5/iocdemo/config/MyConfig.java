package com.wellsfargo.batch5.iocdemo.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.wellsfargo.batch5.iocdemo.serivce")
public class MyConfig {

	@Bean
	public LocalDateTime current() {
		return LocalDateTime.now();
	}
}
