package web.app.common;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebAppServletContextListener implements ServletContextListener{

    //Run this before web application is started
	public void contextInitialized(ServletContextEvent event) {

		ServletContext servletCtx = event.getServletContext();
		
		//Set system services instance
    	servletCtx.setAttribute("SystemServices", SystemServices.getInstance());
		
		KeyPairGenerator keyGen;
		KeyPair pair;
		PrivateKey privateKey;
		PublicKey publicKey;		
		
		try {
			
			keyGen = KeyPairGenerator.getInstance("RSA");
			keyGen.initialize(512);
			pair = keyGen.generateKeyPair();
			
			publicKey = pair.getPublic();
			servletCtx.setAttribute("PublicKey", publicKey);			
			
			privateKey = pair.getPrivate();
			servletCtx.setAttribute("PrivateKey", privateKey);
		
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("ServletContextListener started");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EclipseLink_H2Database");
		servletCtx.setAttribute(AppConstants.H2_EMF, emf);		
		System.out.println("H2 Entity Manager Factory Set");
		
		emf = Persistence.createEntityManagerFactory("EclipseLink_SQLServer");
		servletCtx.setAttribute(AppConstants.MSSQL_EMF, emf);
		System.out.println("SQL Server Entity Manager Factory Set");

	}
		
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("ServletContextListener destroyed");
	}

}
