package com.wellsfargo.swmd;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/*equivalenet to web.xml*/
public class WebAppConfig implements WebApplicationInitializer {

	public void onStartup(ServletContext ctx) throws ServletException {
		AnnotationConfigWebApplicationContext webCtx = 
				new AnnotationConfigWebApplicationContext();

		webCtx.register(SpringWebMvcDemoConfig.class);
		webCtx.setServletContext(ctx);

		/*
		 * <web-app> <servlet> <servlet-name>dispatcher</servlet-name>
		 * <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-
		 * class> <load-on-startup>1</load-on-startup> </servlet> <servlet-mapping>
		 * <servlet-name>dispatcher</servlet-name> <url-pattern>/</url-pattern>
		 * </servlet-mapping> </web-app>
		 */

		ServletRegistration.Dynamic servlet = ctx.addServlet("dispatcher", new DispatcherServlet(webCtx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");

		// for xml based config you have to create a xml file called
		// dispatcher-servlet.xml
		// that will work as your bean definition file....

	}
}
