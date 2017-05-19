package web.app.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import web.app.common.LoginObject;

@Path("/login")
public class LoginService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LoginObject login(LoginObject loginObject){
		String uNamePass = new String(Base64.getDecoder().decode(loginObject.getuNamePass()));
		System.out.println(uNamePass);
		return loginObject;
	}
}
