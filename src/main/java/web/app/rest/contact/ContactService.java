package web.app.rest.contact;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

import web.app.common.AppConstants;
import web.app.common.User;
import web.app.jpamodel.company.SpCompanyNewCheckParams;
import web.app.jpamodel.company.SpCompanyNewCheckResults;
import web.app.jpamodel.company.SpFindCompany;
import web.app.jpamodel.contact.SpContactNewCheckParams;
import web.app.jpamodel.contact.SpContactNewCheckResults;
import web.app.jpamodel.contact.SpFindContactResult;
import web.app.jpamodel.contact.TblContactAffiliates;
import web.app.jpamodel.contact.TblContactAffiliatesKey;
import web.app.jpamodel.contact.TblContactComments;
import web.app.jpamodel.contact.TblContactReps;
import web.app.jpamodel.contact.TblContactRepsKey;
import web.app.jpamodel.contact.TblContacts;
import web.app.jpamodel.contact.TblContactsDiscipline;
import web.app.jpamodel.contact.TblContactsDisciplineKey;
import web.app.rest.ApplicationServiceBase;
import web.app.rest.company.CompanyEntity;

@Path("/contacts")
public class ContactService extends ApplicationServiceBase {
	
	@Path("/get({id})")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@RolesAllowed({"1"})
	public ContactEntity getContactEntity(@Context SecurityContext securityContext, @PathParam("id") long id) {
		ContactEntity contactEntity = new ContactEntity();			
		
		TblContacts contact = null;		
		List<TblContactComments> comments = new ArrayList<TblContactComments>();		
		List<TblContactsDiscipline> disciplines = new ArrayList<TblContactsDiscipline>();		
		List<TblContactAffiliates> affiliates = new ArrayList<TblContactAffiliates>();		
		List<TblContactReps> reps = new ArrayList<TblContactReps>();
		
		//Get Entity Manager
		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();		
				
		contact = em.find(TblContacts.class, id);		
		if (contact != null ){
			//Set selected contact 
			contactEntity.setContact(contact);
			
			//Get Contact Comments 
			TypedQuery<TblContactComments> queryComments = em.createQuery("SELECT comments FROM TblContactComments comments WHERE comments.cocContactID = :contactID", TblContactComments.class);
			queryComments.setParameter("contactID", contact.getConID());
			comments = queryComments.getResultList();
			//Set selected comments to company entity
			contactEntity.setComments(comments);	
			
			
			//Get Contact Disciplines 
			TypedQuery<TblContactsDiscipline> queryDesciplines = em.createQuery("SELECT disciplines FROM TblContactsDiscipline disciplines WHERE disciplines.key.codContactID = :contactID", TblContactsDiscipline.class);
			queryDesciplines.setParameter("contactID", contact.getConID());
			disciplines = queryDesciplines.getResultList();
			//Set selected comments to company entity
			contactEntity.setDisciplines(disciplines);
			

			//Get Contact Affiliates 
			TypedQuery<TblContactAffiliates> queryAffiliates = em.createQuery("SELECT affiliates FROM TblContactAffiliates affiliates WHERE affiliates.key.cafContactID = :contactID", TblContactAffiliates.class);
			queryAffiliates.setParameter("contactID", contact.getConID());
			affiliates = queryAffiliates.getResultList();
			//Set selected comments to company entity
			contactEntity.setAffiliates(affiliates);
			

			//Get Contact Reps 
			TypedQuery<TblContactReps> queryReps = em.createQuery("SELECT reps FROM TblContactReps reps WHERE reps.key.corContactID = :contactID", TblContactReps.class);
			queryReps.setParameter("contactID", contact.getConID());
			reps = queryReps.getResultList();
			//Set selected comments to company entity
			contactEntity.setReps(reps);						
			
		}

		return contactEntity;
	}
	
	@Path("/create")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ContactEntity postContactEntity(@Context SecurityContext securityContext, ContactEntity contactEntity) {

		EntityManagerFactory emf = (EntityManagerFactory)servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();		
		em.persist(contactEntity.getContact());
		//flush so that newly created id is reflected on entity object 
		em.flush();
		
		//Save Comments 
		for (TblContactComments comments : contactEntity.getComments()) {
			comments.setCocContactID(contactEntity.getContact().getConID());
			em.persist(comments);
		}
		
		//Save Disciplines
		for (TblContactsDiscipline discipline : contactEntity.getDisciplines()) {
			TblContactsDisciplineKey disciplineKey = discipline.getKey();			
			disciplineKey.setCodContactID(contactEntity.getContact().getConID());			
			em.persist(discipline);
		}

		//Save Affiliates
		for (TblContactAffiliates affiliate : contactEntity.getAffiliates()) {
			TblContactAffiliatesKey affiliateKey = affiliate.getKey();
			affiliateKey.setCafContactID(contactEntity.getContact().getConID());
			em.persist(affiliate);
		}

		//Save Reps
		for (TblContactReps rep : contactEntity.getReps()) {
			TblContactRepsKey repKey = rep.getKey();
			repKey.setCorContactID(contactEntity.getContact().getConID());
			em.persist(rep);
		}				
		
		em.getTransaction().commit();
		em.close();
		return contactEntity;
	}	

    @Path("/change")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ContactEntity putContactEntity(@Context SecurityContext securityContext, ContactEntity contactEntity) {

		EntityManagerFactory emf = (EntityManagerFactory)servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();		
		em.merge(contactEntity.getContact());
		
		//Save Comments 
		for (TblContactComments comments : contactEntity.getComments()) {
			em.merge(comments);
		}
		
		//Save Disciplines
		for (TblContactsDiscipline discipline : contactEntity.getDisciplines()) {
			em.merge(discipline);
		}

		//Save Affiliates
		for (TblContactAffiliates affiliate : contactEntity.getAffiliates()) {
			em.merge(affiliate);
		}

		//Save Reps
		for (TblContactReps rep : contactEntity.getReps()) {
			em.merge(rep);
		}				
		
		em.getTransaction().commit();
		em.close();
		return contactEntity;
	}	
		
	@Path("/findcontactadvall")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ContactEntity findContactsAdvancedAll(@Context SecurityContext securityContext, ContactEntity contactEntity) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();
		
		User user = (User)securityContext.getUserPrincipal();
				
		Query query = em.createNamedStoredProcedureQuery("spFindContactsAdvancedAll");
		query.setParameter("conName", contactEntity.getFindParams().getConName());
		query.setParameter("empID", user.getUserName());
		//query.setParameter("Inactive", companyEntity.getCompany().getComInactive());
		
		List<SpFindContactResult> resultList = (List<SpFindContactResult>)query.getResultList();
	
		em.close();
		
		contactEntity.setFindResults(resultList);
		return contactEntity;

	}	

	@Path("/findcontactadv")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ContactEntity findContactsAdvanced(@Context SecurityContext securityContext, ContactEntity contactEntity) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();
		
		User user = (User)securityContext.getUserPrincipal();
				
		Query query = em.createNamedStoredProcedureQuery("spFindContactsAdvanced");
				
		query.setParameter("conName", contactEntity.getFindParams().getConName());
		query.setParameter("empID", user.getUserName());
		query.setParameter("Inactive", contactEntity.getFindParams().getConInactive());
		
		List<SpFindContactResult> resultList = (List<SpFindContactResult>)query.getResultList();
		
		
		em.close();
		
		contactEntity.setFindResults(resultList);
		return contactEntity;

	}	
	
	
	@Path("/newcheck")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<SpContactNewCheckResults> spContactNewCheck(@Context SecurityContext securityContext, SpContactNewCheckParams params) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();
			
		Query query = em.createNamedStoredProcedureQuery("spContactNewCheck");
		query.setParameter("conFName", params.getConFName().substring(0,2));
		query.setParameter("conLName", params.getConLName());
		
		List<SpContactNewCheckResults> resultList = (List<SpContactNewCheckResults>)query.getResultList();
		
		em.close();		

		return resultList;
		
	}
	
	
	
}
