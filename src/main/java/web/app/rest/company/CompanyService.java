package web.app.rest.company;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

import com.sun.research.ws.wadl.Application;

import web.app.jpamodel.company.TblCompany;
import web.app.jpamodel.company.TblCompanyComments;
import web.app.rest.ApplicationServiceBase;

@Path("/company({id})")
public class CompanyService extends ApplicationServiceBase{

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed({"1"})
	public CompanyEntity getCompanyEntity(@PathParam("id") long id) {
        
		CompanyEntity companyEntity = new CompanyEntity();
		List<TblCompanyComments> companyComments = new ArrayList<TblCompanyComments>();
		TblCompany tblCompany = null;		
		
		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute("SQLServerEMF");
		EntityManager em = emf.createEntityManager();		
		tblCompany = em.find(TblCompany.class, id);
		if (tblCompany != null){
			companyEntity.setCompany(tblCompany);					
			TypedQuery<TblCompanyComments> query = em.createQuery("SELECT cc FROM TblCompanyComments cc WHERE cc.cmcCompanyID = :comID", TblCompanyComments.class);
			query.setParameter("comID",  String.valueOf(tblCompany.getComID()));
			companyComments = query.getResultList();
			companyEntity.setComments(companyComments);		
		}
		
		em.close();
		return companyEntity;
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CompanyEntity postCompanyEntity(CompanyEntity companyEntity) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute("SQLServerEMF");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();		
		em.persist(companyEntity.getCompany());
		
		for (TblCompanyComments companyComments : companyEntity.getComments()) {
			em.persist(companyComments);
			em.flush();
			em.clear();
		}

		em.getTransaction().commit();
		em.close();
		return companyEntity;
	}
	

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CompanyEntity putCompanyEntity(CompanyEntity companyEntity) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute("SQLServerEMF");
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
	
	
	

}
