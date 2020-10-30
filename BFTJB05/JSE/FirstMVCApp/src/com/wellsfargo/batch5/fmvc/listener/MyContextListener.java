package com.wellsfargo.batch5.fmvc.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {


    public void contextDestroyed(ServletContextEvent arg0)  { 
    	//left blank intentionally
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
         ServletContext ctx = arg0.getServletContext();
         
         ctx.setInitParameter("dbUrl", "jdbc:mysql://localhost:3306/db");
         ctx.setInitParameter("dbUnm", "root");
         ctx.setInitParameter("dbPwd", "root");
         
    }
	
}
