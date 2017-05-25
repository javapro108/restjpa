package web.app.rest.company;

import java.util.ArrayList;
import java.util.List;

import web.app.jpamodel.company.TblCompany;
import web.app.jpamodel.company.TblCompanyComments;

public class CompanyEntity {
	private TblCompany company;
	private List<TblCompanyComments> comments = new ArrayList<TblCompanyComments>();
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
}
