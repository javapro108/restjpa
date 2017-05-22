package web.app.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import web.app.jpamodel.TblCompany;

@Path("/tblcompany({id})")
public class TblCompanyService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TblCompany getCompanyEntity(@Context ServletContext context, @PathParam("id") long id) {

		TblCompany tblCompany = new TblCompany();
		EntityManagerFactory emf = (EntityManagerFactory) context.getAttribute("SQLServerEMF");
		EntityManager em = emf.createEntityManager();
		tblCompany = em.find(TblCompany.class, id);
		em.close();
		return tblCompany;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public TblCompany postCompanyEntity(@Context ServletContext context, TblCompany tblCompany) {

		EntityManagerFactory emf = (EntityManagerFactory) context.getAttribute("SQLServerEMF");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();		
		em.merge(tblCompany);
		em.getTransaction().commit();
		em.close();
		return tblCompany;
	}
	
	
}
