package web.app.rest.contact;

import java.util.ArrayList;
import java.util.List;

import web.app.jpamodel.contact.TblContactAffiliates;
import web.app.jpamodel.contact.TblContactReps;
import web.app.jpamodel.contact.TblContactsDiscipline;
import web.app.jpamodel.contact.sp.SpContactCommentsResults;
import web.app.jpamodel.contact.sp.SpContactJobsResults;
import web.app.jpamodel.contact.sp.SpContactMarketingResults;
import web.app.jpamodel.contact.sp.SpContactProjectsResults;
import web.app.jpamodel.contact.sp.SpContactViewResults;

public class ContactDetailsEntity {
	
	private SpContactViewResults contact;
	
	private List<SpContactCommentsResults> comments = new ArrayList<SpContactCommentsResults>(); 
	
	private List<SpContactJobsResults> jobs = new ArrayList<SpContactJobsResults>();
	
	private List<SpContactProjectsResults> projects = new ArrayList<SpContactProjectsResults>();
	
	private List<TblContactsDiscipline> disciplines = new ArrayList<TblContactsDiscipline>();
	
	private List<TblContactAffiliates> affiliates = new ArrayList<TblContactAffiliates>();

	private List<TblContactReps> reps = new ArrayList<TblContactReps>();
	
	private List<SpContactMarketingResults> marketings = new ArrayList<SpContactMarketingResults>();
	

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
	public List<TblContactsDiscipline> getDisciplines() {
		return disciplines;
	}
	public void setDisciplines(List<TblContactsDiscipline> disciplines) {
		this.disciplines = disciplines;
	}
	public List<TblContactAffiliates> getAffiliates() {
		return affiliates;
	}
	public void setAffiliates(List<TblContactAffiliates> affiliates) {
		this.affiliates = affiliates;
	}
	public List<TblContactReps> getReps() {
		return reps;
	}
	public void setReps(List<TblContactReps> reps) {
		this.reps = reps;
	}
	public List<SpContactMarketingResults> getMarketings() {
		return marketings;
	}
	public void setMarketings(List<SpContactMarketingResults> marketing) {
		this.marketings = marketing;
	}

	
}
