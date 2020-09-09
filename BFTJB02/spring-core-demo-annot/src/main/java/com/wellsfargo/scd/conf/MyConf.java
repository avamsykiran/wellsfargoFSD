package com.wellsfargo.scd.conf;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan({"com.wellsfargo.scd.service","com.wellsfargo.scd.util"})
public class MyConf {

	@Bean
	@Scope("prototype")
	public LocalDateTime today() {		
		return LocalDateTime.now();
	}
}
