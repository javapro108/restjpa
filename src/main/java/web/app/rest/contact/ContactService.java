package web.app.rest.contact;

import java.util.ArrayList;
import java.util.Date;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import web.app.common.AppConstants;
import web.app.common.LockObject;
import web.app.common.SystemServices;
import web.app.common.User;
import web.app.jpamodel.company.SpCompanyNewCheckParams;
import web.app.jpamodel.company.SpCompanyNewCheckResults;
import web.app.jpamodel.company.SpFindCompany;
import web.app.jpamodel.company.TblCompanyComments;
import web.app.jpamodel.company.sp.SpCompanyTableResults;
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
import web.app.jpamodel.contact.sp.SpContactParams;
import web.app.jpamodel.contact.sp.SpContactViewResults;
import web.app.rest.ApplicationServiceBase;
import web.app.rest.company.CompanyEntity;

@Path("/contacts")
public class ContactService extends ApplicationServiceBase {
	
	@Path("/get({id})")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@RolesAllowed({"1"})
	public ContactEntity getContactEntity(@Context SecurityContext securityContext, @PathParam("id") long id, @QueryParam("lock") boolean lock) {
		
		ContactEntity contactEntity = new ContactEntity();			
		
		TblContacts contact = null;		
		List<TblContactComments> comments = new ArrayList<TblContactComments>();		
		List<TblContactsDiscipline> disciplines = new ArrayList<TblContactsDiscipline>();		
		List<TblContactAffiliates> affiliates = new ArrayList<TblContactAffiliates>();		
		List<TblContactReps> reps = new ArrayList<TblContactReps>();
		
		User user = (User) securityContext.getUserPrincipal();
		
		if (lock == true ){
			SystemServices sysService = (SystemServices) servletContext.getAttribute(AppConstants.SYSTEM_SERVICE);
			LockObject lockObject = new LockObject();
			
			lockObject.setObjectId(Long.toString(id));
			lockObject.setObjectType("CONTACT");
			lockObject.setLockedBy(user.getUserName());
			
			if (!sysService.lockObject(lockObject)){
				contactEntity.addMessage("Contact locked for edit");
				return contactEntity;
			};			
			
		}		
		
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
			TypedQuery<TblContactsDiscipline> queryDesciplines = em.createQuery("SELECT disciplines FROM TblContactsDiscipline disciplines WHERE disciplines.codContactID = :contactID", TblContactsDiscipline.class);
			queryDesciplines.setParameter("contactID", contact.getConID());
			disciplines = queryDesciplines.getResultList();
			//Set selected comments to company entity
			contactEntity.setDisciplines(disciplines);
			

			//Get Contact Affiliates 
			TypedQuery<TblContactAffiliates> queryAffiliates = em.createQuery("SELECT affiliates FROM TblContactAffiliates affiliates WHERE affiliates.cafContactID = :contactID", TblContactAffiliates.class);
			queryAffiliates.setParameter("contactID", contact.getConID());
			affiliates = queryAffiliates.getResultList();
			//Set selected comments to company entity
			contactEntity.setAffiliates(affiliates);
			

			//Get Contact Reps 
			TypedQuery<TblContactReps> queryReps = em.createQuery("SELECT reps FROM TblContactReps reps WHERE reps.corContactID = :contactID", TblContactReps.class);
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
			discipline.setCodContactID(contactEntity.getContact().getConID());			
			em.persist(discipline);
		}

		//Save Affiliates
		for (TblContactAffiliates affiliate : contactEntity.getAffiliates()) {
			affiliate.setCafContactID(contactEntity.getContact().getConID());
			em.persist(affiliate);
		}

		//Save Reps
		for (TblContactReps rep : contactEntity.getReps()) {
			rep.setCorContactID(contactEntity.getContact().getConID());
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
	public ContactEntity putContactEntity(@Context SecurityContext securityContext, ContactEntity contactEntity, @QueryParam("unlock") boolean unLock) {

		User user = (User) securityContext.getUserPrincipal();

		SystemServices sysService = (SystemServices) servletContext.getAttribute(AppConstants.SYSTEM_SERVICE);
		LockObject lockObject = new LockObject();
		
		lockObject.setObjectId(Long.toString(contactEntity.getContact().getConID()));
		lockObject.setObjectType("CONTACT");
		lockObject.setLockedBy(user.getUserName());
		
		if (!sysService.lockObject(lockObject)){
			contactEntity.addMessage("Contact not locked for edit, please try again.");
			return contactEntity;
		}
    	
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
		
		if (unLock == true ){
			sysService.unLockObject(lockObject);			
		}			
		
		return contactEntity;
	}
    
    
    @Path("/addcomment")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public TblContactComments addComment(@Context SecurityContext securityContext, TblContactComments contactComment) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();
		
		User user = (User) securityContext.getUserPrincipal();
		
		contactComment.setCocDate(new Date());
		contactComment.setCocUser(user.getUserName());
		em.merge(contactComment);

		em.getTransaction().commit();
		em.close();
		return contactComment;
		
	}
    
    

    @Path("/details")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ContactDetailsEntity contactDetails(@Context SecurityContext securityContext, SpContactParams params) {
    	
    	ContactDetailsEntity contactDetails = new ContactDetailsEntity();
    	
    	SpContactViewResults contact = null;
    	
    	List<SpContactViewResults> contactList = null;
    	
		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();
		
		User user = (User)securityContext.getUserPrincipal();
		if (params.getEmpID() == null){
			params.setEmpID(user.getUserName());
		}
		
		if (params.getGetContactDetail()){			
			Query qCompany = em.createNamedStoredProcedureQuery("spContactView");		
			qCompany.setParameter("conID", params.getConID());
			qCompany.setParameter("empID", params.getEmpID());		
			contactList = (List<SpContactViewResults>)qCompany.getResultList();
			if (contactList.iterator().hasNext()){
				contact = contactList.iterator().next();				
			}											
		}
    	
    	if (contact != null ){
    		contactDetails.setContact(contact);    		
    	}
    	
    	return contactDetails;
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
