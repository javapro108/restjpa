package web.app.common;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebAppServletContextListener implements ServletContextListener{

    //Run this before web application is started
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContextListener started");
	}
		
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextListener destroyed");
	}

	
}
