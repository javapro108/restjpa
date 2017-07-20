package web.app.rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import web.app.common.AppConstants;
import web.app.common.LoginObject;
import web.app.common.SystemServices;
import web.app.common.User;
import web.app.jpamodel.ObjectAddress;
import web.app.jpamodel.employee.TblEmpRoles;
import web.app.jpamodel.employee.TblEmployees;

@Path("/login")
public class LoginService extends ApplicationServiceBase{
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LoginObject login(LoginObject loginObject){
		String uNamePass = new String(Base64.getDecoder().decode(loginObject.getuNamePass()));
		String login[] =  uNamePass.split(":");
		if (login == null || login.length != 2 ) {
			return loginObject;
		}
		User user = this.loginUser(login[0], login[1]); 
		if (user != null){
			UUID uId = UUID.randomUUID();
			String token = uId.toString();			
			loginObject.setToken(token);
			loginObject.setuNamePass(""); // Clear user name password
			loginObject.setFirstName(user.getFirstName());
			loginObject.setLastName(user.getLastName());
			loginObject.setUserName(user.getUserName().toUpperCase());
			SystemServices.getInstance().addLiveUser(token, user);
		}
		return loginObject;
	}
	
	
	private User loginUser(String uName, String password){		
		User user = null;

		TblEmployees employee = null;		
		EntityManagerFactory emf = (EntityManagerFactory)servletContext.getAttribute(AppConstants.MSSQL_EMF);
		EntityManager em = emf.createEntityManager();
		
		uName.toUpperCase();
		
		employee = em.find(TblEmployees.class, uName);
		
		TypedQuery<TblEmpRoles> query = em.createQuery("SELECT er FROM TblEmpRoles er WHERE er.emrEmpUserName = :empId", TblEmpRoles.class);

		query.setParameter("empId", uName);
		List<TblEmpRoles> roles = query.getResultList();
		
		em.close();
		
		if (employee != null && employee.getEmpPassword().equals(password)){
			//Validate user name and password here and create User object
			user = new User();
			user.setFirstName(employee.getEmpName());
			user.setLastName("");			
			user.setUserName(uName);
			user.setDepartment(employee.getEmpDept());
			user.setLastLoginTime(new Date());
			user.setEmail(employee.getEmpEmail());		
			if (roles != null){
				for (TblEmpRoles role:roles){
					user.addRole(role.getEmrRolID());
				}
			}
		}

		return user;	
	} 
}
