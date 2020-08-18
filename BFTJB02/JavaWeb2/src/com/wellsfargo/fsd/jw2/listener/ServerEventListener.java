package com.wellsfargo.fsd.jw2.listener;

import java.time.LocalDateTime;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServerEventListener
 *
 */
@WebListener
public class ServerEventListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServerEventListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
        System.out.println("Sever Stoped @ " + LocalDateTime.now());
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
        System.out.println("Sever Started @ " + LocalDateTime.now()); 
    }
	
}
