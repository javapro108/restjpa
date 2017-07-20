package web.app.rest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import web.app.common.AppConstants;
import web.app.common.LockObject;
import web.app.common.SystemServices;
import web.app.common.User;
import web.app.jpamodel.common.TblAffiliates;
import web.app.jpamodel.common.TblCountry;
import web.app.jpamodel.common.TblDiscipline;
import web.app.jpamodel.common.TblDistrict;
import web.app.jpamodel.common.TblPosition;
import web.app.jpamodel.common.TblPrefix;
import web.app.jpamodel.common.TblStates;
import web.app.jpamodel.common.TblStatusCodeAff;
import web.app.jpamodel.common.sp.SpRepDropDown;
import web.app.jpamodel.employee.SpEmpDistrictsResults;
import web.app.jpamodel.employee.TblEmployees;
import web.app.rest.common.InitAppEntity;


@Path("/app")
public class AppService extends ApplicationServiceBase {
	
	@Path("/lock")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean lockObject(@Context ServletContext context, LockObject lockObject) {
		
		SystemServices sysService = (SystemServices) servletContext.getAttribute(AppConstants.SYSTEM_SERVICE);
		return sysService.lockObject(lockObject);
		
	}
	
	
	@Path("/unlock")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public BaseEntity unLockObject(@Context ServletContext context, LockObject lockObject) {
		BaseEntity baseEntity = new BaseEntity(); 
		SystemServices sysService = (SystemServices) servletContext.getAttribute(AppConstants.SYSTEM_SERVICE);
		if (sysService.unLockObject(lockObject)){
			baseEntity.addMessage("Object unlocked.");
		} else {
			baseEntity.addMessage("Error unlocking object");
		}
		return baseEntity;
		
	}
	
	
	@Path("/initapp")
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public InitAppEntity initApp(@Context SecurityContext securityContext) {
		
		InitAppEntity appData = new InitAppEntity();
		List<SpEmpDistrictsResults> empDistricts = new ArrayList<SpEmpDistrictsResults>();
		List<TblStates> states = null;
		List<TblCountry> countries = null;
		List<TblEmployees> employees = null;
		List<SpRepDropDown> repOpts = null;
		List<TblPrefix> prefixOpts = null;
		List<TblDiscipline> dispOpts = null;
		List<TblPosition> posOpts = null;
		List<TblAffiliates> empAffOpts = null;
		List<TblAffiliates> affOptsAll = null;
		List<TblStatusCodeAff> affStatus = null;
		
		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();
		
		User user = (User)securityContext.getUserPrincipal();
		
		//Districts
		Query districtsQuery = em.createNamedStoredProcedureQuery("spEmpDistricts");
		districtsQuery.setParameter("emp", user.getUserName());		
		empDistricts = (List<SpEmpDistrictsResults>)districtsQuery.getResultList();
		if ( empDistricts != null){
			appData.setEmpDistricts(empDistricts);
		}

		//States
		TypedQuery<TblStates> statesQuery = em.createQuery("SELECT states FROM TblStates states", TblStates.class);						
		states = (List<TblStates>)statesQuery.getResultList();
		if ( states  != null){
			appData.setStates(states);
		}
		
		//Countries
		TypedQuery<TblCountry> countriesQuery = em.createQuery("SELECT country FROM TblCountry country", TblCountry.class);						
		countries = (List<TblCountry>)countriesQuery.getResultList();
		if ( countries != null){
			appData.setCountries(countries);
		}
		
		//Reps
		TypedQuery<TblEmployees> repsQuery = em.createQuery("Select emp from TblEmployees emp", TblEmployees.class);		
		employees = (List<TblEmployees>)repsQuery.getResultList();
		if ( employees != null){
			for (TblEmployees employee : employees ){
				employee.setEmpPassword("");
			}
			appData.setEmployees(employees);
		}
		
		//Reps Opts
		Query repOptsQuery = em.createNamedStoredProcedureQuery("spRepDropDown");		
		repOpts = (List<SpRepDropDown>)repOptsQuery.getResultList();
		if ( repOpts != null){
			appData.setRepOpts(repOpts);
		}
		
		//Prefix Opts
		TypedQuery<TblPrefix> prefixQuery = em.createQuery("SELECT prefix FROM TblPrefix prefix", TblPrefix.class);						
		prefixOpts = (List<TblPrefix>)prefixQuery.getResultList();
		if ( prefixOpts != null){
			appData.setPrefixOpts(prefixOpts);
		}
		
		//Discipline Opts
		Query dispOptsQuery = em.createNamedStoredProcedureQuery("spDiscipline");		
		dispOpts = (List<TblDiscipline>)dispOptsQuery.getResultList();
		if ( dispOpts != null){
			appData.setDispOpts(dispOpts);
		}
		
		//Position Opts
		Query posOptsQuery = em.createNamedStoredProcedureQuery("spPositionDropdown");		
		posOpts = (List<TblPosition>)posOptsQuery.getResultList();
		if ( posOpts != null){
			appData.setPosOpts(posOpts);
		}
		
		//Affiliate Opts
		Query affOptsQuery = em.createNamedStoredProcedureQuery("spAffiliateDropdown");	
		affOptsQuery.setParameter("empID", user.getUserName());
		empAffOpts = (List<TblAffiliates>)affOptsQuery.getResultList();
		if ( empAffOpts != null){
			appData.setEmpAffOpts(empAffOpts);
		}
		
		//Affiliate Opts All
		Query affOptsAllQuery = em.createNamedStoredProcedureQuery("spAffiliate");	
		affOptsAll = (List<TblAffiliates>)affOptsAllQuery.getResultList();
		if ( affOptsAll != null){
			appData.setAffOptsAll(affOptsAll);
		}
		
		//Affiliate Status
		TypedQuery<TblStatusCodeAff> affStatusQuery = em.createQuery("SELECT affStatus FROM TblStatusCodeAff affStatus", TblStatusCodeAff.class);						
		affStatus = (List<TblStatusCodeAff>)affStatusQuery.getResultList();	
		if ( affStatus != null){
			appData.setAffStatus(affStatus);
		}		
		
		em.close();
		
		return appData;
		
	}
	
	@Path("/districts")
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<TblDistrict> spGetDistricts(@Context SecurityContext securityContext) {
		List<TblDistrict> districts = new ArrayList<TblDistrict>();

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<TblDistrict> distQuery = em.createQuery("SELECT dists FROM TblDistrict dists", TblDistrict.class);						
		districts = (List<TblDistrict>) distQuery.getResultList();	
		
		return districts;
	}

/*	
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
	
	
	@Path("/reps")
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<TblEmployees> getRepsDropdown(@Context SecurityContext securityContext) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();

		TypedQuery<TblEmployees> query = em.createQuery(
				"Select emp from TblEmployees emp", 
				TblEmployees.class);		
		List<TblEmployees> resultList = (List<TblEmployees>)query.getResultList();
		
		em.close();
		
		for(TblEmployees rep: resultList ){
			rep.setEmpPassword("");			
		}
		
		return resultList;
		
	}
	
	@Path("/repdropdown")
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<SpRepDropDown> getReps(@Context SecurityContext securityContext) {

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
	
	
	@Path("/affiliates")
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<TblAffiliates> spAffiliate(@Context SecurityContext securityContext) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();

		Query query = em.createNamedStoredProcedureQuery("spAffiliate");	
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
*/
}
