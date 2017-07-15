package web.app.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

import web.app.common.AppConstants;

public class ApplicationServiceBase {

	@Context protected ServletContext servletContext;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	public Date date_19000101 = new Date();
	
	public ApplicationServiceBase(){
		try {
			date_19000101 = dateFormat.parse("1900-01-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	 
/*	protected EntityManagerFactory emf;
	protected EntityManager em;		
	

	public ApplicationServiceBase(@Context ServletContext servletContext) {
		super();
		this.servletContext = servletContext;
		this.emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		this.em = this.emf.createEntityManager();		
				
	}	
*/	
}
