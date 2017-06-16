package web.app.rest.employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import web.app.common.AppConstants;
import web.app.jpamodel.employee.SpEmpDistrictsParams;
import web.app.jpamodel.employee.SpEmpDistrictsResults;
import web.app.rest.ApplicationServiceBase;


@Path("/employee")
public class EmployeeService extends ApplicationServiceBase{

	@Path("/getdistricts")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<SpEmpDistrictsResults> spEmpDistricts(@Context SecurityContext securityContext, SpEmpDistrictsParams params) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();
			
		Query query = em.createNamedStoredProcedureQuery("spEmpDistricts");
		query.setParameter("emp", params.getEmp());
		
		List<SpEmpDistrictsResults> resultList = (List<SpEmpDistrictsResults>)query.getResultList();
		
		em.close();		

		return resultList;
		
	}
	
}
