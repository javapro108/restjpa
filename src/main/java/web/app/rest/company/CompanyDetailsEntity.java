package web.app.rest.company;

import java.util.ArrayList;
import java.util.List;

import web.app.jpamodel.company.sp.SpCompanyCommentsResults;
import web.app.jpamodel.company.sp.SpCompanyContactActivityResults;
import web.app.jpamodel.company.sp.SpCompanyContactsResults;
import web.app.jpamodel.company.sp.SpCompanyJobsResults;
import web.app.jpamodel.company.sp.SpCompanyMarketingResults;
import web.app.jpamodel.company.sp.SpCompanyProjectsResults;
import web.app.jpamodel.company.sp.SpCompanyTableResults;

public class CompanyDetailsEntity {

	private SpCompanyTableResults company = null;
	private List<SpCompanyCommentsResults> comments = new ArrayList<SpCompanyCommentsResults>();
	private List<SpCompanyContactsResults> contacts = new ArrayList<SpCompanyContactsResults>();
	private List<SpCompanyContactActivityResults> contactActivities = new ArrayList<SpCompanyContactActivityResults>();
	private List<SpCompanyMarketingResults> marketings = new ArrayList<SpCompanyMarketingResults>();
	private List<SpCompanyJobsResults> jobs = new ArrayList<SpCompanyJobsResults>();
	private List<SpCompanyProjectsResults> projects = new ArrayList<SpCompanyProjectsResults>();
	
	public SpCompanyTableResults getCompany() {
		return company;
	}
	public void setCompany(SpCompanyTableResults company) {
		this.company = company;
	}
	public List<SpCompanyCommentsResults> getComments() {
		return comments;
	}
	public void setComments(List<SpCompanyCommentsResults> comments) {
		this.comments = comments;
	}
	public List<SpCompanyContactsResults> getContacts() {
		return contacts;
	}
	public void setContacts(List<SpCompanyContactsResults> contacts) {
		this.contacts = contacts;
	}
	public List<SpCompanyContactActivityResults> getContactActivities() {
		return contactActivities;
	}
	public void setContactActivities(List<SpCompanyContactActivityResults> contactActivities) {
		this.contactActivities = contactActivities;
	}
	public List<SpCompanyMarketingResults> getMarketings() {
		return marketings;
	}
	public void setMarketings(List<SpCompanyMarketingResults> marketings) {
		this.marketings = marketings;
	}
	public List<SpCompanyJobsResults> getJobs() {
		return jobs;
	}
	public void setJobs(List<SpCompanyJobsResults> jobs) {
		this.jobs = jobs;
	}
	public List<SpCompanyProjectsResults> getProjects() {
		return projects;
	}
	public void setProjects(List<SpCompanyProjectsResults> projects) {
		this.projects = projects;
	}
	
}
