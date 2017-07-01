package web.app.jpamodel.contact.sp;

public class SpContactParams {
	
	private long conID;
	
	private String empID;
	
	private Boolean getContactDetail = false;
	
	private Boolean getComments = false;
	
	private Boolean getAvtivities = false;
	
	private Boolean getJobs = false;
	
	private Boolean getProjects = false;
	
	private Boolean getMarketing = false;
	
	private Boolean getStatus = false;
	
	private Boolean getDiscipline = false;


	public long getConID() {
		return conID;
	}

	public void setConID(long conID) {
		this.conID = conID;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public Boolean getGetContactDetail() {
		return getContactDetail;
	}

	public void setGetContactDetail(Boolean getContactDetail) {
		this.getContactDetail = getContactDetail;
	}

	public Boolean getGetComments() {
		return getComments;
	}

	public void setGetComments(Boolean getComments) {
		this.getComments = getComments;
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

	public Boolean getGetStatus() {
		return getStatus;
	}

	public void setGetStatus(Boolean getStatus) {
		this.getStatus = getStatus;
	}

	public Boolean getGetDiscipline() {
		return getDiscipline;
	}

	public void setGetDiscipline(Boolean getDiscipline) {
		this.getDiscipline = getDiscipline;
	}
	
}
