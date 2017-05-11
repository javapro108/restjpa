package web.app.common;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebAppServletContextListener implements ServletContextListener{

    //Run this before web application is started
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("ServletContextListener started");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		event.getServletContext().setAttribute("EMF", emf);
		System.out.println("Entity Manager Factory Set");
	}
		
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("ServletContextListener destroyed");
	}

	
}
