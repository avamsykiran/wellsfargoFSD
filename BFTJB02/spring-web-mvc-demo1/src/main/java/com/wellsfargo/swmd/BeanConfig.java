package com.wellsfargo.swmd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.wellsfargo.swmd")
@EnableWebMvc
public class BeanConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		
		vr.setPrefix("/views/");
		vr.setSuffix(".jsp");
		vr.setOrder(1);
		
		return vr;
	}
}
