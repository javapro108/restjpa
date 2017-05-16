package web.app.rest;

import javax.ws.rs.Path;

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

import web.app.jpamodel.Company;
import web.app.jpamodel.ObjectAddress;
import web.app.jpamodel.ObjectAddressKey;

@Path("/company({id})")
public class CompanyService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CompanyEntity getCompanyEntity(@Context ServletContext context, @PathParam("id") Long id) {
		CompanyEntity company = new CompanyEntity();
		ObjectAddress objAddr;
		Company companyHeader;

		EntityManagerFactory emf = (EntityManagerFactory) context.getAttribute("EMF");
		EntityManager em = emf.createEntityManager();
		companyHeader = em.find(Company.class, id);
		if (companyHeader != null) {
			company.setCompanyHeader(companyHeader);
			//Get Addresses
			TypedQuery<ObjectAddress> query = em.createQuery("SELECT oa FROM ObjectAddress oa WHERE oa.addressKey.objectId = :objId AND oa.addressKey.objectType = :objType", ObjectAddress.class);
			query.setParameter("objId", companyHeader.getId());
			query.setParameter("objType", companyHeader.getObjectType());
			List<ObjectAddress> addresses = query.getResultList();
			company.setAddresses(addresses);
		}
		em.close();
		return company;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CompanyEntity postCompanyEntity(@Context ServletContext context, CompanyEntity company) {

		ObjectAddressKey addrKey;

		EntityManagerFactory emf = (EntityManagerFactory) context.getAttribute("EMF");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		em.merge(company.getCompanyHeader());
		for (ObjectAddress objAddr : company.getAddresses()) {

			addrKey = new ObjectAddressKey();
			addrKey.setObjectType(company.getCompanyHeader().getObjectType());
			addrKey.setObjectId(company.getCompanyHeader().getId());
			addrKey.setAddrType(objAddr.getAddrType());
			objAddr.setAddressKey(addrKey);
			em.merge(objAddr);
			em.flush();
			em.clear();

		}

		em.getTransaction().commit();
		em.close();
		return company;
	}

}
