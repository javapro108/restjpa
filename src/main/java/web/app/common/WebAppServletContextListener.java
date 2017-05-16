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

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EclipseLink_H2Database");
		event.getServletContext().setAttribute("EMF", emf);		
		System.out.println("H2 Entity Manager Factory Set");
		
		emf = Persistence.createEntityManagerFactory("EclipseLink_SQLServer");
		event.getServletContext().setAttribute("SQLServerEMF", emf);
		System.out.println("SQL Server Entity Manager Factory Set");

	}
		
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("ServletContextListener destroyed");
	}

}
