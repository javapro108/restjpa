package web.app.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import web.app.common.LoginObject;
import web.app.common.SystemServices;
import web.app.common.User;

@Path("/login")
public class LoginService {
	
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
			loginObject.setUserName(user.getUserName());
			SystemServices.addLiveUser(token, user);
		}
		return loginObject;
	}
	private User loginUser(String uName, String password){		
		User user = null;
		//Validate user name and password here and create User object
		user = new User();
		user.setFirstName("FirstName");
		user.setLastName("LastName");
		user.setUserName(uName);
		return user;
	} 
}
