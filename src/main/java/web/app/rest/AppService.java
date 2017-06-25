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
import web.app.common.User;
import web.app.jpamodel.common.TblAffiliates;
import web.app.jpamodel.common.TblCountry;
import web.app.jpamodel.common.TblDiscipline;
import web.app.jpamodel.common.TblPosition;
import web.app.jpamodel.common.TblPrefix;
import web.app.jpamodel.common.TblStates;
import web.app.jpamodel.common.TblStatusCodeAff;
import web.app.jpamodel.common.sp.SpRepDropDown;
import web.app.jpamodel.company.SpFindCompany;

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
	
	
	@Path("/repdropdown")
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<SpRepDropDown> spRepDropDown(@Context SecurityContext securityContext) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();

		Query query = em.createNamedStoredProcedureQuery("spRepDropDown");		
		List<SpRepDropDown> resultList = (List<SpRepDropDown>)query.getResultList();
		
		em.close();
		
		return resultList;
		
	}
	
	@Path("/prefixes")
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<TblPrefix> getTblPrefix(@Context SecurityContext securityContext) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<TblPrefix> query = em.createQuery("SELECT prefix FROM TblPrefix prefix", TblPrefix.class);				
		
		List<TblPrefix> prefix = (List<TblPrefix>)query.getResultList();
		
		em.close();		

		return prefix;
		
	}
	
	
	@Path("/disciplinedropdown")
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<TblDiscipline> spDiscipline(@Context SecurityContext securityContext) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createNamedStoredProcedureQuery("spDiscipline");		
		List<TblDiscipline> resultList = (List<TblDiscipline>)query.getResultList();
		
		em.close();
		
		return resultList;
		
	}

	
	@Path("/positiondropdown")
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<TblPosition> spPositionDropdown(@Context SecurityContext securityContext) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createNamedStoredProcedureQuery("spPositionDropdown");		
		List<TblPosition> resultList = (List<TblPosition>)query.getResultList();
		
		em.close();
		
		return resultList;
		
	}
	
	
	@Path("/affiliatedropdown")
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<TblAffiliates> spAffiliateDropdown(@Context SecurityContext securityContext) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();
		
		User user = (User)securityContext.getUserPrincipal();

		Query query = em.createNamedStoredProcedureQuery("spAffiliateDropdown");	
		query.setParameter("empID", user.getUserName());
		List<TblAffiliates> resultList = (List<TblAffiliates>)query.getResultList();
		
		em.close();
		
		return resultList;
		
	}
	
	
	@Path("/affstatus")
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<TblStatusCodeAff> getAffStatus(@Context SecurityContext securityContext) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<TblStatusCodeAff> query = em.createQuery("SELECT affStatus FROM TblStatusCodeAff affStatus", TblStatusCodeAff.class);				
		
		List<TblStatusCodeAff> affStatusses = (List<TblStatusCodeAff>)query.getResultList();
		
		em.close();		

		return affStatusses;
		
	}	
	
}
