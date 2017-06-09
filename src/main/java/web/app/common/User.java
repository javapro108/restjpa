package web.app.common;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.SecurityContext;

public class User extends LoginObject implements SecurityContext, Principal{
	
	private Date lastLoginTime = new Date();
	
	private List<String> roles = new ArrayList<String>();
	@Override
	public String getAuthenticationScheme() {
		// TODO Auto-generated method stub
		return "Token-Based-Auth-Scheme";
	}
	@Override
	public Principal getUserPrincipal() {
		return this;
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
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return userName;
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
