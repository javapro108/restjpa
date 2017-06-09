package web.app.rest.company;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import web.app.jpamodel.company.SpFindCompany;
import web.app.jpamodel.company.TblCompanyComments;
import web.app.rest.ApplicationServiceBase;

@Path("/findcompany1({id})")
public class FindCompanyService extends ApplicationServiceBase{

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<SpFindCompany> findCompany(CompanyEntity companyEntity) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute("SQLServerEMF");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createNamedStoredProcedureQuery("spFindCompany");
		query.setParameter("comName", companyEntity.getCompany().getComName());
		query.setParameter("empID", "spp");
		query.setParameter("Inactive", false);
		
		List<SpFindCompany> resultList = (List<SpFindCompany>)query.getResultList();
	
		em.close();
		return resultList;

	}
			
}
