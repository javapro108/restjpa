package web.app.rest.contact;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import web.app.jpamodel.contact.sp.SpContactCommentsResults;
import web.app.jpamodel.contact.sp.SpContactJobsResults;
import web.app.jpamodel.contact.sp.SpContactMarketingResults;
import web.app.jpamodel.contact.sp.SpContactParams;
import web.app.jpamodel.contact.sp.SpContactProjectsResults;
import web.app.jpamodel.contact.sp.SpContactViewResults;
import web.app.rest.ApplicationServiceBase;
import web.app.rest.company.CompanyEntity;

@Path("/contacts")
public class ContactService extends ApplicationServiceBase {


	@Path("/get({id})")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// @RolesAllowed({"1"})
	public ContactEntity getContactEntity(@Context SecurityContext securityContext, @PathParam("id") long id,
			@QueryParam("lock") boolean lock) {

		ContactEntity contactEntity = new ContactEntity();

		TblContacts contact = null;
		List<TblContactComments> comments = new ArrayList<TblContactComments>();
		List<TblContactsDiscipline> disciplines = new ArrayList<TblContactsDiscipline>();
		List<TblContactAffiliates> affiliates = new ArrayList<TblContactAffiliates>();
		List<TblContactReps> reps = new ArrayList<TblContactReps>();

		User user = (User) securityContext.getUserPrincipal();

		if (lock == true) {
			SystemServices sysService = (SystemServices) servletContext.getAttribute(AppConstants.SYSTEM_SERVICE);
			LockObject lockObject = new LockObject();

			lockObject.setObjectId(Long.toString(id));
			lockObject.setObjectType("CONTACT");
			lockObject.setLockedBy(user.getUserName());

			if (!sysService.lockObject(lockObject)) {
				contactEntity.addMessage("Contact locked for edit");
				return contactEntity;
			}

		}

		// Get Entity Manager
		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();

		contact = em.find(TblContacts.class, id);
		if (contact != null) {
			// Set selected contact
			contactEntity.setContact(contact);

			// Get Contact Comments
			TypedQuery<TblContactComments> queryComments = em.createQuery(
					"SELECT comments FROM TblContactComments comments WHERE comments.cocContactID = :contactID",
					TblContactComments.class);
			queryComments.setParameter("contactID", contact.getConID());
			comments = queryComments.getResultList();
			// Set selected comments to company entity
			contactEntity.setComments(comments);

			// Get Contact Disciplines
			TypedQuery<TblContactsDiscipline> queryDesciplines = em.createQuery(
					"SELECT disciplines FROM TblContactsDiscipline disciplines WHERE disciplines.codContactID = :contactID",
					TblContactsDiscipline.class);
			queryDesciplines.setParameter("contactID", contact.getConID());
			disciplines = queryDesciplines.getResultList();
			// Set selected comments to company entity
			contactEntity.setDisciplines(disciplines);

			// Get Contact Affiliates
			TypedQuery<TblContactAffiliates> queryAffiliates = em.createQuery(
					"SELECT affiliates FROM TblContactAffiliates affiliates WHERE affiliates.cafContactID = :contactID",
					TblContactAffiliates.class);
			queryAffiliates.setParameter("contactID", contact.getConID());
			affiliates = queryAffiliates.getResultList();
			// Set selected comments to company entity
			contactEntity.setAffiliates(affiliates);

			// Get Contact Reps
			TypedQuery<TblContactReps> queryReps = em.createQuery(
					"SELECT reps FROM TblContactReps reps WHERE reps.corContactID = :contactID", TblContactReps.class);
			queryReps.setParameter("contactID", contact.getConID());
			reps = queryReps.getResultList();
			// Set selected comments to company entity
			contactEntity.setReps(reps);

		}

		return contactEntity;
	}

	@Path("/create")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ContactEntity postContactEntity(@Context SecurityContext securityContext, ContactEntity contactEntity) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();
		
		User user = (User) securityContext.getUserPrincipal();

		em.getTransaction().begin();
		
		contactEntity.getContact().setConCreatedBy(user.getUserName());
		//contactEntity.getContact().setConDate(new Date());
		contactEntity.getContact().setConRevisedBy(user.getUserName());
		contactEntity.getContact().setConRevisedDate(date_19000101);
		contactEntity.getContact().setConInactive(false);
				
		if (contactEntity.getContact().getConBirthday() == null ){
			contactEntity.getContact().setConBirthday(date_19000101);
		}
		if (contactEntity.getContact().getConAnniversary() == null ){
			contactEntity.getContact().setConAnniversary(date_19000101);
		}		
		
		em.persist(contactEntity.getContact());
		// flush so that newly created id is reflected on entity object
		em.flush();

		// Save Comments
		if (contactEntity.getComments() != null) {
			for (TblContactComments comment : contactEntity.getComments()) {
				if (comment != null && !comment.getCmdComment().isEmpty()) {
					comment.setCocDate(new Date());
					comment.setCocUser(user.getUserName());
					comment.setCocContactID(contactEntity.getContact().getConID());
					em.persist(comment);
				}
			}
		}

		// Save Disciplines
		if (contactEntity.getDisciplines() != null) {
			for (TblContactsDiscipline discipline : contactEntity.getDisciplines()) {
				if (discipline.getMode().equals("I")) {
					discipline.setCodContactID(contactEntity.getContact().getConID());
					em.persist(discipline);
				}
			}
		}

		// Save Affiliates
		if (contactEntity.getAffiliates() != null) {
			for (TblContactAffiliates affiliate : contactEntity.getAffiliates()) {
				if (affiliate.getMode().equals("I")) {
					affiliate.setCafContactID(contactEntity.getContact().getConID());
					em.persist(affiliate);
				}
			}
		}

		// Save Reps
		if (contactEntity.getReps() != null) {
			for (TblContactReps rep : contactEntity.getReps()) {
				if (rep.getMode().equals("I")) {
					rep.setCorContactID(contactEntity.getContact().getConID());
					rep.setCorLastContact(date_19000101);
					em.persist(rep);
				}
			}
		}

		em.getTransaction().commit();
		em.close();
		return contactEntity;
	}

	@Path("/change")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ContactEntity putContactEntity(@Context SecurityContext securityContext, ContactEntity contactEntity,
			@QueryParam("unlock") boolean unLock) {

		List<TblContactsDiscipline> disciplinesIns = new ArrayList<TblContactsDiscipline>();
		List<TblContactsDiscipline> disciplinesUpd = new ArrayList<TblContactsDiscipline>();
		List<TblContactsDiscipline> disciplinesDel = new ArrayList<TblContactsDiscipline>();

		List<TblContactReps> repsIns = new ArrayList<TblContactReps>();
		List<TblContactReps> repsUpd = new ArrayList<TblContactReps>();
		List<TblContactReps> repsDel = new ArrayList<TblContactReps>();

		List<TblContactAffiliates> affiliatesIns = new ArrayList<TblContactAffiliates>();
		List<TblContactAffiliates> affiliatesUpd = new ArrayList<TblContactAffiliates>();
		List<TblContactAffiliates> affiliatesDel = new ArrayList<TblContactAffiliates>();

		User user = (User) securityContext.getUserPrincipal();

		LockObject lockObject = new LockObject();
		lockObject.setObjectId(Long.toString(contactEntity.getContact().getConID()));
		lockObject.setObjectType("CONTACT");
		lockObject.setLockedBy(user.getUserName());

		SystemServices sysService = (SystemServices) servletContext.getAttribute(AppConstants.SYSTEM_SERVICE);

		if (!sysService.lockObject(lockObject)) {
			contactEntity.addMessage("Contact not locked for edit, please try again.");
			return contactEntity;
		}

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();

		
		contactEntity.getContact().setConRevisedBy(user.getUserName());
		contactEntity.getContact().setConRevisedDate(new Date());
		
		if (contactEntity.getContact().getConBirthday() == null ){
			contactEntity.getContact().setConBirthday(date_19000101);
		}
		if (contactEntity.getContact().getConAnniversary() == null ){
			contactEntity.getContact().setConAnniversary(date_19000101);
		}
		
		em.getTransaction().begin();
		em.merge(contactEntity.getContact());

		// Save Comments
		for (TblContactComments comment : contactEntity.getComments()) {	
			if (comment != null && !comment.getCmdComment().isEmpty()) {
				comment.setCocDate(new Date());
				comment.setCocUser(user.getUserName());
				comment.setCocContactID(contactEntity.getContact().getConID());
				em.merge(comment);
			}
		}

		// Save Disciplines
		if (contactEntity.getDisciplines() != null) {
			for (TblContactsDiscipline discipline : contactEntity.getDisciplines()) {
				if (discipline != null) {
					if (discipline.getMode().equals("I")) {
						disciplinesIns.add(discipline);
					}
					if (discipline.getMode().equals("U")) {
						disciplinesUpd.add(discipline);
					}
					if (discipline.getMode().equals("D")) {
						disciplinesDel.add(discipline);
					}
				}
			}

			for (TblContactsDiscipline disciplineDel : disciplinesDel) {
				
				TblContactsDisciplineKey disciplineKey = new TblContactsDisciplineKey();
				disciplineKey.setCodContactID(disciplineDel.getCodContactID());
				disciplineKey.setCodDisciplineID(disciplineDel.getCodDisciplineID());
				
				disciplineDel = em.find(TblContactsDiscipline.class, disciplineKey);
				em.remove(disciplineDel);
			
			}

			for (TblContactsDiscipline disciplineIns : disciplinesIns) {
				em.persist(disciplineIns);
			}
			for (TblContactsDiscipline disciplineUpd : disciplinesUpd) {
				em.merge(disciplineUpd);
			}
		}

		// Save Affiliates
		if (contactEntity.getAffiliates() != null) {
			for (TblContactAffiliates affiliate : contactEntity.getAffiliates()) {
				if ( affiliate != null ) {
					if (affiliate.getMode().equals("I")) {
						affiliatesIns.add(affiliate);
					}
					if (affiliate.getMode().equals("U")) {
						affiliatesUpd.add(affiliate);
					}
					if (affiliate.getMode().equals("D")) {
						affiliatesDel.add(affiliate);
					}
				}
			}

			for (TblContactAffiliates affiliateDel : affiliatesDel) {
				
				TblContactAffiliatesKey affiliateKey = new TblContactAffiliatesKey();
				affiliateKey.setCafAffialiateID(affiliateDel.getCafAffialiateID());
				affiliateKey.setCafContactID(affiliateDel.getCafContactID());				
				
				affiliateDel = em.find(TblContactAffiliates.class, affiliateKey);
				em.remove(affiliateDel);
				
			}
			
			for (TblContactAffiliates affiliateUpd : affiliatesUpd) {
				em.merge(affiliateUpd);
			}
			
			for (TblContactAffiliates affiliateIns : affiliatesIns) {
				em.persist(affiliateIns);
			}
			
		}

		// Save Reps
		if (contactEntity.getReps() != null) {
			for (TblContactReps rep : contactEntity.getReps()) {
				if ( rep != null ) {
					if (rep.getMode().equals("I")) {
						repsIns.add(rep);
					}
					if (rep.getMode().equals("U")) {
						repsUpd.add(rep);
					}
					if (rep.getMode().equals("D")) {
						repsDel.add(rep);
					}
				}
			}
			for (TblContactReps repDel : repsDel) {
				
				TblContactRepsKey repKey = new TblContactRepsKey();
				repKey.setCorContactID(repDel.getCorContactID());
				repKey.setCorAffialiateID(repDel.getCorAffialiateID());
				repKey.setCorRepID(repDel.getCorRepID());
				
				repDel = em.find(TblContactReps.class,repKey);
				em.remove(repDel);				
				
			}
			for (TblContactReps repIns : repsIns) {
				repIns.setCorLastContact(date_19000101);
				em.persist(repIns);
			}
			for (TblContactReps repUpd : repsUpd) {
				if (repUpd.getCorLastContact() == null){
					repUpd.setCorLastContact(date_19000101);
				}
				em.merge(repUpd);
			}
		}

		em.getTransaction().commit();
		em.close();

		if (unLock == true) {
			sysService.unLockObject(lockObject);
		}

		return contactEntity;
	}

	@Path("/addcomment")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public TblContactComments addComment(@Context SecurityContext securityContext, TblContactComments comment) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();

		User user = (User) securityContext.getUserPrincipal();
		if (comment != null && !comment.getCmdComment().isEmpty()) {
			comment.setCocDate(new Date());
			comment.setCocUser(user.getUserName());
		}

		em.getTransaction().begin();
		em.persist(comment);
		em.getTransaction().commit();
		em.close();
		
		return comment;

	}

	@Path("/details")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ContactDetailsEntity contactDetails(@Context SecurityContext securityContext, SpContactParams params) {

		ContactDetailsEntity contactDetails = new ContactDetailsEntity();

		SpContactViewResults contact = null;

		List<SpContactViewResults> contactList = null;
		List<SpContactCommentsResults> comments = null;
		List<SpContactJobsResults> jobs = null;
		List<SpContactProjectsResults> projects = null;
		List<SpContactMarketingResults> marketings = null;
		List<TblContactsDiscipline> disciplines = null;
		List<TblContactAffiliates> affiliates = null;
		List<TblContactReps> reps = null;
		
		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();

		User user = (User) securityContext.getUserPrincipal();
		if (params.getEmpID() == null) {
			params.setEmpID(user.getUserName());
		}

		if (params.getGetContactDetail()) {
			Query qContact = em.createNamedStoredProcedureQuery("spContactView");
			qContact.setParameter("conID", params.getConID());
			qContact.setParameter("empID", params.getEmpID());
			contactList = (List<SpContactViewResults>) qContact.getResultList();
			if (contactList.iterator().hasNext()) {
				contact = contactList.iterator().next();				
			}
			
			// Get Contact Disciplines
			TypedQuery<TblContactsDiscipline> queryDesciplines = em.createQuery(
					"SELECT disciplines FROM TblContactsDiscipline disciplines WHERE disciplines.codContactID = :contactID",
					TblContactsDiscipline.class);
			queryDesciplines.setParameter("contactID", params.getConID());
			disciplines = queryDesciplines.getResultList();
			// Set selected comments to company entity

			// Get Contact Affiliates
			TypedQuery<TblContactAffiliates> queryAffiliates = em.createQuery(
					"SELECT affiliates FROM TblContactAffiliates affiliates WHERE affiliates.cafContactID = :contactID",
					TblContactAffiliates.class);
			queryAffiliates.setParameter("contactID", params.getConID());
			affiliates = queryAffiliates.getResultList();
			// Set selected comments to company entity

			// Get Contact Reps
			TypedQuery<TblContactReps> queryReps = em.createQuery(
					"SELECT reps FROM TblContactReps reps WHERE reps.corContactID = :contactID", TblContactReps.class);
			queryReps.setParameter("contactID", params.getConID());
			reps = queryReps.getResultList();
			// Set selected comments to company entity			
			
		}
		

		if (params.getGetComments()) {
			Query qComments = em.createNamedStoredProcedureQuery("spContactComments");
			qComments.setParameter("conID", params.getConID());
			comments = (List<SpContactCommentsResults>) qComments.getResultList();
		}		
		

		if (params.getGetJobs()) {
			Query qJobs = em.createNamedStoredProcedureQuery("spContactJobs");
			qJobs.setParameter("conID", params.getConID());
			qJobs.setParameter("empID", params.getEmpID());
			jobs = (List<SpContactJobsResults>) qJobs.getResultList();
		}

		if (params.getGetProjects()) {
			Query qProjects = em.createNamedStoredProcedureQuery("spContactProjects");
			qProjects.setParameter("conID", params.getConID());
			qProjects.setParameter("empID", params.getEmpID());
			projects = (List<SpContactProjectsResults>) qProjects.getResultList();
		}
		
		if (params.getGetMarketing()) {
			Query qMarketing = em.createNamedStoredProcedureQuery("spContactMarketing");
			qMarketing.setParameter("conID", params.getConID());
			marketings = (List<SpContactMarketingResults>) qMarketing.getResultList();						
		}
		
		em.close();
		

		if (contact != null) {
			contactDetails.setContact(contact);
			if (disciplines != null) {
				contactDetails.setDisciplines(disciplines);
			}
			if (affiliates != null){
				contactDetails.setAffiliates(affiliates);
			}
			if (reps != null) {
				contactDetails.setReps(reps);
			}
		}
		if (comments != null){
			contactDetails.setComments(comments);
		}
		if (jobs != null) {
			contactDetails.setJobs(jobs);
		}
		if (projects != null) {
			contactDetails.setProjects(projects);
		}
		if (marketings != null) {
			contactDetails.setMarketings(marketings);
		}				

		return contactDetails;
		
	}

	@Path("/findcontactadvall")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ContactEntity findContactsAdvancedAll(@Context SecurityContext securityContext,
			ContactEntity contactEntity) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();

		User user = (User) securityContext.getUserPrincipal();

		Query query = em.createNamedStoredProcedureQuery("spFindContactsAdvancedAll");
		query.setParameter("conName", contactEntity.getFindParams().getConName());
		query.setParameter("empID", user.getUserName());
		// query.setParameter("Inactive",
		// companyEntity.getCompany().getComInactive());

		List<SpFindContactResult> resultList = (List<SpFindContactResult>) query.getResultList();

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

		User user = (User) securityContext.getUserPrincipal();

		Query query = em.createNamedStoredProcedureQuery("spFindContactsAdvanced");

		query.setParameter("conName", contactEntity.getFindParams().getConName());
		query.setParameter("empID", user.getUserName());
		query.setParameter("Inactive", contactEntity.getFindParams().getConInactive());

		List<SpFindContactResult> resultList = (List<SpFindContactResult>) query.getResultList();

		em.close();

		contactEntity.setFindResults(resultList);
		return contactEntity;

	}

	@Path("/newcheck")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<SpContactNewCheckResults> spContactNewCheck(@Context SecurityContext securityContext,
			SpContactNewCheckParams params) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();

		Query query = em.createNamedStoredProcedureQuery("spContactNewCheck");
		query.setParameter("conFName", params.getConFName().substring(0, 2));
		query.setParameter("conLName", params.getConLName());

		List<SpContactNewCheckResults> resultList = (List<SpContactNewCheckResults>) query.getResultList();

		em.close();

		return resultList;

	}

}
