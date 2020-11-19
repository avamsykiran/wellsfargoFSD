package com.wellsfargo.batch7.iocdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.wellsfargo.batch7.iocdemo.service",
	"com.wellsfargo.batch7.iocdemo.util"})
public class MyConfig {

}
