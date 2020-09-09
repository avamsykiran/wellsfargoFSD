package com.wellsfargo.swmd;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppConf implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext appContext
			= new AnnotationConfigWebApplicationContext();
		
		appContext.register(BeanConfig.class);
		appContext.setServletContext(servletContext);
		
		ServletRegistration.Dynamic dyn = 
					servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
		dyn.setLoadOnStartup(1);
		dyn.addMapping("/");
				
	}

}
