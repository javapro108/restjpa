package web.app.rest.contact;

import java.util.ArrayList;
import java.util.List;

import web.app.jpamodel.contact.FindParams;
import web.app.jpamodel.contact.SpFindContactResult;
import web.app.jpamodel.contact.TblContactAffiliates;
import web.app.jpamodel.contact.TblContactComments;
import web.app.jpamodel.contact.TblContactReps;
import web.app.jpamodel.contact.TblContacts;
import web.app.jpamodel.contact.TblContactsDiscipline;

public class ContactEntity {
	
	private TblContacts contact = new TblContacts();
	
	private List<TblContactComments> comments = new ArrayList<TblContactComments>();
	
	private List<TblContactsDiscipline> disciplines = new ArrayList<TblContactsDiscipline>();
	
	private List<TblContactAffiliates> affiliates = new ArrayList<TblContactAffiliates>();
	
	private List<TblContactReps> reps = new ArrayList<TblContactReps>();
	
	private FindParams findParams;
	
	private List<SpFindContactResult> findResults = new ArrayList<SpFindContactResult>(); 

	public TblContacts getContact() {
		return contact;
	}

	public void setContact(TblContacts contact) {
		this.contact = contact;
	}

	public List<TblContactComments> getComments() {
		return comments;
	}

	public void setComments(List<TblContactComments> comments) {
		this.comments = comments;
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

	public FindParams getFindParams() {
		return findParams;
	}

	public void setFindParams(FindParams findParams) {
		this.findParams = findParams;
	}

	public List<SpFindContactResult> getFindResults() {
		return findResults;
	}

	public void setFindResults(List<SpFindContactResult> findResults) {
		this.findResults = findResults;
	}

}
