package web.app.rest;

import java.util.List;

import web.app.jpamodel.Company;
import web.app.jpamodel.ObjectAddress;

public class CompanyEntity {
	
	private Company companyHeader; 
	private List<ObjectAddress> addresses;
	
	public Company getCompanyHeader() {
		return companyHeader;
	}
	public void setCompanyHeader(Company companyHeader) {
		this.companyHeader = companyHeader;
	}
	public List<ObjectAddress> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<ObjectAddress> addresses) {
		this.addresses = addresses;
	}	

}
