package web.app.rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

import web.app.common.AppConstants;

public class ApplicationServiceBase {

	@Context protected ServletContext servletContext;
	
	protected EntityManagerFactory emf;
	protected EntityManager em;		
	

	public ApplicationServiceBase() {
		super();
		
		emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		em = emf.createEntityManager();		
				
	}
	
}
