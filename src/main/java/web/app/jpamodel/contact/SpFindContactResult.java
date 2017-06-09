package web.app.jpamodel.contact;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
		    name="spFindContactsAdvancedAll", 
		    procedureName="spFindContactsAdvancedAll", 
		    parameters = {
		        @StoredProcedureParameter(name = "conName", mode=ParameterMode.IN, type = String.class),
		        @StoredProcedureParameter(name = "empID", mode=ParameterMode.IN, type = String.class)
		    },
		    resultClasses = {SpFindContactResult.class}
	), 	
	@NamedStoredProcedureQuery(
		    name="spFindContactsAdvanced", 
		    procedureName="spFindContactsAdvanced", 
		    parameters = {
		        @StoredProcedureParameter(name = "conName", mode=ParameterMode.IN, type = String.class),
		        @StoredProcedureParameter(name = "empID", mode=ParameterMode.IN, type = String.class),
		        @StoredProcedureParameter(name = "Inactive", mode=ParameterMode.IN, type = Boolean.class)
		    },
		    resultClasses = {SpFindContactResult.class}
	)
})
@Entity
public class SpFindContactResult {
	
	@Id
	@Column(name = "conID", length = 18)
	private long conID;

	@Column(name = "conFName", length = 30)
	private String conFName;

	@Column(name = "conLName", length = 30)
	private String conLName;

	@Column(name = "conAlias", length = 30)
	private String conAlias;

	@Column(name = "conPosition", length = 10)
	private String conPosition;	
	
	@Column(name = "conTitle", length = 50)
	private String conTitle;
	
	@Column(name = "conDirectPhone", length = 10)
	private String conDirectPhone;
	
	@Column(name = "conEmail", length = 50)
	private String conEmail;

	@Column(name = "comDistrict", length = 5)
	private String comDistrict;

	@Column(name = "comName", length = 50)
	private String comName;

	@Column(name = "comPhone", length = 10)
	private String comPhone;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "actDate")
	private Date actDate;

	public long getConID() {
		return conID;
	}

	public void setConID(long conID) {
		this.conID = conID;
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

	public String getConAlias() {
		return conAlias;
	}

	public void setConAlias(String conAlias) {
		this.conAlias = conAlias;
	}

	public String getConPosition() {
		return conPosition;
	}

	public void setConPosition(String conPosition) {
		this.conPosition = conPosition;
	}

	public String getConTitle() {
		return conTitle;
	}

	public void setConTitle(String conTitle) {
		this.conTitle = conTitle;
	}

	public String getConDirectPhone() {
		return conDirectPhone;
	}

	public void setConDirectPhone(String conDirectPhone) {
		this.conDirectPhone = conDirectPhone;
	}

	public String getConEmail() {
		return conEmail;
	}

	public void setConEmail(String conEmail) {
		this.conEmail = conEmail;
	}

	public String getComDistrict() {
		return comDistrict;
	}

	public void setComDistrict(String comDistrict) {
		this.comDistrict = comDistrict;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getComPhone() {
		return comPhone;
	}

	public void setComPhone(String comPhone) {
		this.comPhone = comPhone;
	}

	public Date getActDate() {
		return actDate;
	}

	public void setActDate(Date actDate) {
		this.actDate = actDate;
	}	
	
}
