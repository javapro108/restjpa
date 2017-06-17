package web.app.jpamodel.company.sp;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@NamedStoredProcedureQuery(
		name="spCompanyContacts", 
		procedureName="spCompanyContacts", 
		parameters = {
		    @StoredProcedureParameter(name = "comID", mode=ParameterMode.IN, type = Long.class),
		    @StoredProcedureParameter(name = "empID", mode=ParameterMode.IN, type = String.class)
		},
		resultClasses = {SpCompanyContactsResults.class}
	)
@Entity
public class SpCompanyContactsResults {
	
	@Id
	@Column(name = "")
	private String conid;
	
	@Column(name = "")
	private String conFName;
	
	@Column(name = "")
	private String conLName;
	
	@Column(name = "")
	private String conPosition;
	
	@Column(name = "")
	private String conName;
	
	@Column(name = "")
	private String conDirectPhone; 
	
	@Column(name = "")
	private String conExt;
	
	@Column(name = "")
	private String conEmail; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "")
	private Date actLastContact;
	
	@Column(name = "")
	private String conCellPhone;
	
	@Column(name = "")
	private String conTitle;
	
	@Column(name = "")
	private String conAssistemail;

	public String getConid() {
		return conid;
	}

	public void setConid(String conid) {
		this.conid = conid;
	}

	public String getConFName() {
		return conFName;
	}

	public void setConFName(String conFName) {
		this.conFName = conFName;
	}

	public String getConLName() {
		return conLName;
	}

	public void setConLName(String conLName) {
		this.conLName = conLName;
	}

	public String getConPosition() {
		return conPosition;
	}

	public void setConPosition(String conPosition) {
		this.conPosition = conPosition;
	}

	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	public String getConDirectPhone() {
		return conDirectPhone;
	}

	public void setConDirectPhone(String conDirectPhone) {
		this.conDirectPhone = conDirectPhone;
	}

	public String getConExt() {
		return conExt;
	}

	public void setConExt(String conExt) {
		this.conExt = conExt;
	}

	public String getConEmail() {
		return conEmail;
	}

	public void setConEmail(String conEmail) {
		this.conEmail = conEmail;
	}

	public Date getActLastContact() {
		return actLastContact;
	}

	public void setActLastContact(Date actLastContact) {
		this.actLastContact = actLastContact;
	}

	public String getConCellPhone() {
		return conCellPhone;
	}

	public void setConCellPhone(String conCellPhone) {
		this.conCellPhone = conCellPhone;
	}

	public String getConTitle() {
		return conTitle;
	}

	public void setConTitle(String conTitle) {
		this.conTitle = conTitle;
	}

	public String getConAssistemail() {
		return conAssistemail;
	}

	public void setConAssistemail(String conAssistemail) {
		this.conAssistemail = conAssistemail;
	}
	
	
}
