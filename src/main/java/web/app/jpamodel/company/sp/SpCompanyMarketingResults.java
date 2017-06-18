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
		name="spCompanyMarketing", 
		procedureName="spCompanyMarketing", 
		parameters = {
		    @StoredProcedureParameter(name = "comID", mode=ParameterMode.IN, type = Long.class)
		},
		resultClasses = {SpCompanyMarketingResults.class}
	)
@Entity
public class SpCompanyMarketingResults {
	
	@Id
	@Column(name = "mrkID")
	private String mrkID;
	
	@Column(name = "mrkActivityCode")
	private String mrkActivityCode;
	
	@Column(name = "mrkActivitySubcode")
	private String mrkActivitySubcode;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "mrkDate")
	private Date mrkDate;
	
	@Column(name = "mrkRep")
	private String mrkRep;
	
	@Column(name = "mrkName")
	private String mrkName;
	
	@Column(name = "recnCompanyID")
	private String recnCompanyID; 
	
	@Column(name = "recnContactID")
	private String recnContactID;

	public String getMrkID() {
		return mrkID;
	}

	public void setMrkID(String mrkID) {
		this.mrkID = mrkID;
	}

	public String getMrkActivityCode() {
		return mrkActivityCode;
	}

	public void setMrkActivityCode(String mrkActivityCode) {
		this.mrkActivityCode = mrkActivityCode;
	}

	public String getMrkActivitySubcode() {
		return mrkActivitySubcode;
	}

	public void setMrkActivitySubcode(String mrkActivitySubcode) {
		this.mrkActivitySubcode = mrkActivitySubcode;
	}

	public Date getMrkDate() {
		return mrkDate;
	}

	public void setMrkDate(Date mrkDate) {
		this.mrkDate = mrkDate;
	}

	public String getMrkRep() {
		return mrkRep;
	}

	public void setMrkRep(String mrkRep) {
		this.mrkRep = mrkRep;
	}

	public String getMrkName() {
		return mrkName;
	}

	public void setMrkName(String mrkName) {
		this.mrkName = mrkName;
	}

	public String getRecnCompanyID() {
		return recnCompanyID;
	}

	public void setRecnCompanyID(String recnCompanyID) {
		this.recnCompanyID = recnCompanyID;
	}

	public String getRecnContactID() {
		return recnContactID;
	}

	public void setRecnContactID(String recnContactID) {
		this.recnContactID = recnContactID;
	}
	
}
