package com.wellsfargo.batch7.fma.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
         ServletContext context = arg0.getServletContext();
         context.setInitParameter("webAppTitle", "My First Web MVC Appliction");
    }
	
}
