package web.app.rest.employee;


import java.util.List;

import javax.annotation.security.RolesAllowed;
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
import web.app.common.User;
import web.app.jpamodel.employee.SpEmpDistrictsResults;
import web.app.jpamodel.employee.TblEmpAffiliates;
import web.app.jpamodel.employee.TblEmpAffiliatesKey;
import web.app.jpamodel.employee.TblEmpDistricts;
import web.app.jpamodel.employee.TblEmpDistrictsKey;
import web.app.jpamodel.employee.TblEmpRoles;
import web.app.jpamodel.employee.TblEmpRolesKey;
import web.app.jpamodel.employee.TblEmployees;
import web.app.rest.ApplicationServiceBase;

@Path("/employee")
public class EmployeeService extends ApplicationServiceBase {

	@Path("/getdistricts")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SpEmpDistrictsResults> spEmpDistricts(@Context SecurityContext securityContext) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();

		User user = (User) securityContext.getUserPrincipal();

		Query query = em.createNamedStoredProcedureQuery("spEmpDistricts");
		query.setParameter("emp", user.getUserName());

		List<SpEmpDistrictsResults> resultList = (List<SpEmpDistrictsResults>) query.getResultList();

		em.close();

		return resultList;

	}

	@Path("/get({id})")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed({ "1", "2" })
	public EmployeeEntity getEmployee(@Context SecurityContext securityContext, @PathParam("id") String empUserName,
			@QueryParam("lock") boolean lock) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();

		EmployeeEntity employeeEntity = new EmployeeEntity();

		TblEmployees employee = em.find(TblEmployees.class, empUserName);

		TypedQuery<TblEmpRoles> queryRoles = em
				.createQuery("SELECT er FROM TblEmpRoles er WHERE er.emrEmpUserName = :empId", TblEmpRoles.class);
		queryRoles.setParameter("empId", employee.getEmpUserName());
		List<TblEmpRoles> empRoles = queryRoles.getResultList();

		TypedQuery<TblEmpAffiliates> queryAffs = em.createQuery(
				"SELECT ea FROM TblEmpAffiliates ea WHERE ea.emaEmpUserName = :empId", TblEmpAffiliates.class);
		queryAffs.setParameter("empId", employee.getEmpUserName());
		List<TblEmpAffiliates> empAffiliates = queryAffs.getResultList();

		TypedQuery<TblEmpDistricts> queryDists = em.createQuery(
				"SELECT ed FROM TblEmpDistricts ed WHERE ed.emdEmpUserName = :empId", TblEmpDistricts.class);
		queryDists.setParameter("empId", employee.getEmpUserName());
		List<TblEmpDistricts> empDistricts = queryDists.getResultList();

		em.close();
		
		employeeEntity.setEmployee(employee);
		employeeEntity.setEmpRoles(empRoles);
		employeeEntity.setEmpAffiliates(empAffiliates);
		employeeEntity.setEmpDistricts(empDistricts);

		return employeeEntity;

	}

	@Path("/getallemployees")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed({ "1", "2" })
	public List<TblEmployees> getAllEmpDetails(@Context SecurityContext securityContext) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();

		TypedQuery<TblEmployees> query = em.createQuery("SELECT emp FROM TblEmployees emp", TblEmployees.class);
		List<TblEmployees> employees = query.getResultList();

		em.close();

		return employees;

	}

	@Path("/create")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@RolesAllowed({ "1", "2" })
	public EmployeeEntity createEmployee(@Context SecurityContext securityContext, EmployeeEntity employeeEntity) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		if (employeeEntity.getEmployee().getMode().equals("I")) {
			em.persist(employeeEntity.getEmployee());
		}

		for (TblEmpRoles empRole : employeeEntity.getEmpRoles()) {
			if (empRole != null && empRole.getMode().equals("I")) {
				empRole.setEmrEmpUserName(employeeEntity.getEmployee().getEmpUserName());
				em.persist(empRole);
			}
		}

		for (TblEmpAffiliates empAffiliate : employeeEntity.getEmpAffiliates()) {
			if (empAffiliate != null && empAffiliate.getMode().equals("I")) {
				empAffiliate.setEmaEmpUserName(employeeEntity.getEmployee().getEmpUserName());
				em.persist(empAffiliate);
			}
		}

		for (TblEmpDistricts empDistricts : employeeEntity.getEmpDistricts()) {
			if (empDistricts != null && empDistricts.getMode().equals("I")) {
				empDistricts.setEmdEmpUserName(employeeEntity.getEmployee().getEmpUserName());
				em.persist(empDistricts);
			}
		}

		em.getTransaction().commit();

		em.close();

		return employeeEntity;
	}

	@Path("/change")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@RolesAllowed({ "1", "2" })
	public EmployeeEntity changeEmployee(@Context SecurityContext securityContext, EmployeeEntity employeeEntity) {

		EntityManagerFactory emf = (EntityManagerFactory) servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		if (employeeEntity.getEmployee().getMode().equals("U")) {
			em.merge(employeeEntity.getEmployee());
		}


		/*
		 * Employee Roles
		 */
		for (TblEmpRoles empRole : employeeEntity.getEmpRoles()) {
			if (empRole != null && empRole.getMode().equals("D")) {
				TblEmpRolesKey empRoleKey = new TblEmpRolesKey();
				empRoleKey.setEmrEmpUserName(empRole.getEmrEmpUserName());
				empRoleKey.setEmrRolID(empRole.getEmrRolID());
				empRole = (TblEmpRoles) em.find(TblEmpRoles.class, empRoleKey);
				em.remove(empRole);
			}
		}

		for (TblEmpRoles empRole : employeeEntity.getEmpRoles()) {
			if (empRole != null && empRole.getMode().equals("I")) {
				em.persist(empRole);
			}
		}

		for (TblEmpRoles empRole : employeeEntity.getEmpRoles()) {
			if (empRole != null && empRole.getMode().equals("U")) {
				em.merge(empRole);
			}
		}


		/*
		 * Employee Affiliates
		 */
		for (TblEmpAffiliates empAffiliate : employeeEntity.getEmpAffiliates()) {
			if (empAffiliate != null && empAffiliate.getMode().equals("D")) {
				TblEmpAffiliatesKey empAffiliateKey = new TblEmpAffiliatesKey();
				empAffiliateKey.setEmaEmpUserName(empAffiliate.getEmaEmpUserName());
				empAffiliateKey.setEmaAffID(empAffiliate.getEmaAffID());
				empAffiliate = em.find(TblEmpAffiliates.class, empAffiliateKey);
				em.remove(empAffiliate);
			}
		}

		for (TblEmpAffiliates empAffiliate : employeeEntity.getEmpAffiliates()) {
			if (empAffiliate != null && empAffiliate.getMode().equals("I")) {
				em.persist(empAffiliate);
			}
		}

		for (TblEmpAffiliates empAffiliate : employeeEntity.getEmpAffiliates()) {
			if (empAffiliate != null && empAffiliate.getMode().equals("U")) {
				em.merge(empAffiliate);
			}
		}


		/*
		 * Employee Districts
		 */
		for (TblEmpDistricts empDistricts : employeeEntity.getEmpDistricts()) {
			if (empDistricts != null && empDistricts.getMode().equals("D")) {
				TblEmpDistrictsKey empDistrictsKey = new TblEmpDistrictsKey();
				empDistrictsKey.setEmdDisID(empDistricts.getEmdDisID());
				empDistrictsKey.setEmdEmpUserName(empDistricts.getEmdEmpUserName());
				empDistricts = em.find(TblEmpDistricts.class, empDistrictsKey);
				em.remove(empDistricts);
			}
		}

		for (TblEmpDistricts empDistricts : employeeEntity.getEmpDistricts()) {
			if (empDistricts != null && empDistricts.getMode().equals("I")) {
				em.persist(empDistricts);
			}
		}

		for (TblEmpDistricts empDistricts : employeeEntity.getEmpDistricts()) {
			if (empDistricts != null && empDistricts.getMode().equals("U")) {
				em.merge(empDistricts);
			}
		}

		em.getTransaction().commit();

		em.close();

		return employeeEntity;
	}

}