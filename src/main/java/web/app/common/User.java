package web.app.common;

import java.security.Principal;
import java.util.List;

import javax.ws.rs.core.SecurityContext;

public class User extends LoginObject implements SecurityContext{
	private List<String> roles;
	@Override
	public String getAuthenticationScheme() {
		// TODO Auto-generated method stub
		return "Token-Based-Auth-Scheme";
	}
	@Override
	public Principal getUserPrincipal() {
		return new Principal(){
			public String getName() {
		        return firstName + " " + lastName;
		    }
		};
	}
	@Override
	public boolean isSecure() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isUserInRole(String role) {
		// TODO Auto-generated method stub
		return roles.contains(role);
	}
	
}
