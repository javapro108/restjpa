package web.app.jpamodel.contact.sp;


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
		name="spContactMarketing", 
		procedureName="spContactMarketing", 
		parameters = {
		    @StoredProcedureParameter(name = "conID", mode=ParameterMode.IN, type = Long.class)
		},
		resultClasses = {SpContactMarketingResults.class}
	)
@Entity
public class SpContactMarketingResults {
	
	@Id
	@Column
	private String mrkID;
	
	@Column
	private String mrkActivityCode;
	
	@Column
	private String mrkActivitySubcode;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date mrkDate;
	
	@Column
	private String mrkRep;
	
	@Column
	private String mrkName;
	
	@Column
	private String recnCompanyID; 
	
	@Column
	private String comName;

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

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	
	
}
