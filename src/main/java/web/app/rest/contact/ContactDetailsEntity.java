package web.app.rest.contact;

import java.util.ArrayList;
import java.util.List;

import web.app.jpamodel.contact.sp.SpContactCommentsResults;
import web.app.jpamodel.contact.sp.SpContactJobsResults;
import web.app.jpamodel.contact.sp.SpContactProjectsResults;
import web.app.jpamodel.contact.sp.SpContactViewResults;

public class ContactDetailsEntity {
	
	private SpContactViewResults contact;
	
	private List<SpContactCommentsResults> comments = new ArrayList<SpContactCommentsResults>(); 
	
	private List<SpContactJobsResults> jobs = new ArrayList<SpContactJobsResults>();
	
	private List<SpContactProjectsResults> projects = new ArrayList<SpContactProjectsResults>();
	
	
	
	public SpContactViewResults getContact() {
		return contact;
	}
	public void setContact(SpContactViewResults contact) {
		this.contact = contact;
	}
	public List<SpContactCommentsResults> getComments() {
		return comments;
	}
	public void setComments(List<SpContactCommentsResults> comments) {
		this.comments = comments;
	}	
	public List<SpContactJobsResults> getJobs() {
		return jobs;
	}
	public void setJobs(List<SpContactJobsResults> jobs) {
		this.jobs = jobs;
	}
	public List<SpContactProjectsResults> getProjects() {
		return projects;
	}
	public void setProjects(List<SpContactProjectsResults> projects) {
		this.projects = projects;
	}


	
}
