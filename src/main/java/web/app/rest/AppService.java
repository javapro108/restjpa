package web.app.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import web.app.common.AppConstants;
import web.app.jpamodel.common.TblCountry;
import web.app.jpamodel.common.TblStates;

@Path("/app")
public class AppService extends ApplicationServiceBase {
	
	@Path("/states")
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<TblStates> spGetStates(@Context SecurityContext securityContext) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<TblStates> query = em.createQuery("SELECT states FROM TblStates states", TblStates.class);				
		
		List<TblStates> states = (List<TblStates>)query.getResultList();
		
		em.close();		

		return states;
		
	}

	@Path("/countries")
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<TblCountry> spGetCountries(@Context SecurityContext securityContext) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<TblCountry> query = em.createQuery("SELECT country FROM TblCountry country", TblCountry.class);				
		
		List<TblCountry> countries = (List<TblCountry>)query.getResultList();
		
		em.close();		

		return countries;
		
	}	

}
