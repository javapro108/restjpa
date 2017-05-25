package web.app.common;

public class LoginObject {
	
	private String uNamePass;
	private String token;
	protected String userName;
	protected String firstName;
	protected String lastName;
	protected String department;
	protected String email;
	
	public String getuNamePass() {
		return uNamePass;
	}
	public void setuNamePass(String uNamePass) {
		this.uNamePass = uNamePass;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
