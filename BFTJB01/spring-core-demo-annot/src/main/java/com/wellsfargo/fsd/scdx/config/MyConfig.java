package com.wellsfargo.fsd.scdx.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.wellsfargo.fsd.scdx.service")
@PropertySource("application.properties")
public class MyConfig {

	@Bean
	public LocalDateTime today() {
		return LocalDateTime.now();
	} 
}
