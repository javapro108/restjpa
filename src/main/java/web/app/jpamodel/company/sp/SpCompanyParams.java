package web.app.jpamodel.company.sp;

public class SpCompanyParams {
	
	private long comID;
	
	private String empID;
	
	private Boolean getCompanyDetail = false;
	
	private Boolean getComments = false;
	
	private Boolean getContacts = false;					
	
	private Boolean getAvtivities = false;
	
	private Boolean getJobs = false;
	
	private Boolean getProjects = false;
	
	private Boolean getMarketing = false;	

	
	public Boolean getGetCompanyDetail() {
		return getCompanyDetail;
	}
	public void setGetCompanyDetail(Boolean getCompanyDetail) {
		this.getCompanyDetail = getCompanyDetail;
	}
	
	public Boolean getGetComments() {
		return getComments;
	}
	public void setGetComments(Boolean getComments) {
		this.getComments = getComments;
	}
	
	public Boolean getGetContacts() {
		return getContacts;
	}
	public void setGetContacts(Boolean getContacts) {
		this.getContacts = getContacts;
	}	
	
	public long getComID() {
		return comID;
	}
	public void setComID(long comID) {
		this.comID = comID;
	}
	
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	
	public Boolean getGetAvtivities() {
		return getAvtivities;
	}
	public void setGetAvtivities(Boolean getAvtivities) {
		this.getAvtivities = getAvtivities;
	}
	
	public Boolean getGetJobs() {
		return getJobs;
	}
	public void setGetJobs(Boolean getJobs) {
		this.getJobs = getJobs;
	}
	
	public Boolean getGetProjects() {
		return getProjects;
	}
	public void setGetProjects(Boolean getProjects) {
		this.getProjects = getProjects;
	}
	
	public Boolean getGetMarketing() {
		return getMarketing;
	}
	public void setGetMarketing(Boolean getMarketing) {
		this.getMarketing = getMarketing;
	}	
	
}
