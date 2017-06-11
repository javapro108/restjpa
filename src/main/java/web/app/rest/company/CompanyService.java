package web.app.rest.company;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import com.sun.research.ws.wadl.Application;

import web.app.common.AppConstants;
import web.app.common.User;
import web.app.jpamodel.company.SpFindCompany;
import web.app.jpamodel.company.TblCompany;
import web.app.jpamodel.company.TblCompanyComments;
import web.app.jpamodel.contact.TblContacts;
import web.app.rest.ApplicationServiceBase;

@Path("/company")
public class CompanyService extends ApplicationServiceBase{

	@Path("/get({id})")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@RolesAllowed({"1"})
	public CompanyEntity getCompanyEntity(@Context SecurityContext securityContext, @PathParam("id") long id) {
        
		CompanyEntity companyEntity = new CompanyEntity();
		List<TblCompanyComments> companyComments = new ArrayList<TblCompanyComments>();
		TblCompany tblCompany = null;
		List<TblContacts> companyContacts = new ArrayList<TblContacts>();
		
		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();		
		tblCompany = em.find(TblCompany.class, id);
		if (tblCompany != null){
			//Set selected company to entity
			companyEntity.setCompany(tblCompany);					

			//Get company comments 
			TypedQuery<TblCompanyComments> queryComments = em.createQuery("SELECT comments FROM TblCompanyComments comments WHERE comments.cmcCompanyID = :comID", TblCompanyComments.class);
			queryComments.setParameter("comID",  String.valueOf(tblCompany.getComID()));
			companyComments = queryComments.getResultList();
			//Set selected comments to company entity
			companyEntity.setComments(companyComments);	
			
			//Get Company Contacts 
			TypedQuery<TblContacts> queryContacts = em.createQuery("SELECT contacts FROM TblContacts contacts WHERE contacts.conCompanyID = :conCompanyID", TblContacts.class);
			queryContacts.setParameter("conCompanyID",  tblCompany.getComID());
			companyContacts = queryContacts.getResultList();
			//Set selected contacts to company entity
			companyEntity.setContacts(companyContacts);	
						
		}
		
		em.close();
		return companyEntity;
	}
	
	@Path("/create")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CompanyEntity postCompanyEntity(@Context SecurityContext securityContext, CompanyEntity companyEntity) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();		
		em.persist(companyEntity.getCompany());
		//flush so that newly created id is reflected on entity object 
		em.flush();
		for (TblCompanyComments companyComments : companyEntity.getComments()) {
			companyComments.setCmcCompanyID(String.valueOf(companyEntity.getCompany().getComID()));
			em.persist(companyComments);
			//em.flush();
			//em.clear();
		}
		em.getTransaction().commit();
		em.close();
		return companyEntity;
	}
	
    @Path("/change")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CompanyEntity putCompanyEntity(@Context SecurityContext securityContext, CompanyEntity companyEntity) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();		
		em.merge(companyEntity.getCompany());
		
		for (TblCompanyComments companyComments : companyEntity.getComments()) {
			em.merge(companyComments);
			//em.flush();
			//em.clear();
		}

		em.getTransaction().commit();
		em.close();
		return companyEntity;
	}
	
	
	@Path("/findcompany")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CompanyEntity findCompany(@Context SecurityContext securityContext, CompanyEntity companyEntity) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();
		
		User user = (User)securityContext.getUserPrincipal();
		
		Query query = em.createNamedStoredProcedureQuery("spFindCompany");
		query.setParameter("comName", companyEntity.getFindParams().getComName());
		query.setParameter("empID", user.getUserName());
		query.setParameter("Inactive", companyEntity.getFindParams().getComInactive());
		
		List<SpFindCompany> resultList = (List<SpFindCompany>)query.getResultList();
				
		em.close();
		
		companyEntity.setFindCompanyResults(resultList);
		return companyEntity;

	}	

}
