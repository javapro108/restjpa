package web.app.rest.company;

import java.util.ArrayList;
import java.util.List;

import web.app.jpamodel.company.SpFindCompany;
import web.app.jpamodel.company.TblCompany;
import web.app.jpamodel.company.TblCompanyComments;
import web.app.jpamodel.contact.TblContacts;

public class CompanyEntity {
	
	private TblCompany company;
	
	private List<TblCompanyComments> comments = new ArrayList<TblCompanyComments>();
	
	private List<TblContacts> contacts = new ArrayList<TblContacts>();
	
	private List<SpFindCompany> findCompanyResults = new ArrayList<SpFindCompany>(); 
	

	public TblCompany getCompany() {
		return company;
	}
	public void setCompany(TblCompany company) {
		this.company = company;
	}
	public List<TblCompanyComments> getComments() {
		return comments;
	}
	public void setComments(List<TblCompanyComments> comments) {
		this.comments = comments;
	}
	public List<TblContacts> getContacts() {
		return contacts;
	}
	public void setContacts(List<TblContacts> contacts) {
		this.contacts = contacts;
	}
	public List<SpFindCompany> getFindCompanyResults() {
		return findCompanyResults;
	}
	public void setFindCompanyResults(List<SpFindCompany> findCompanyResults) {
		this.findCompanyResults = findCompanyResults;
	}

}
