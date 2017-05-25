package web.app.common;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.SecurityContext;

public class User extends LoginObject implements SecurityContext{
	
	private Date lastLoginTime = new Date();
	
	private List<String> roles = new ArrayList<String>();
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
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	public void addRole(String role){
		this.roles.add(role);
	}
	
}
