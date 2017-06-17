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
		name="spCompanyContactActivity", 
		procedureName="spCompanyContactActivity", 
		parameters = {
		    @StoredProcedureParameter(name = "comID", mode=ParameterMode.IN, type = Long.class),
		    @StoredProcedureParameter(name = "empID", mode=ParameterMode.IN, type = String.class)
		},
		resultClasses = {SpCompanyContactActivityResults.class}
	)
@Entity
public class SpCompanyContactActivityResults {
    
	@Id
	@Column(name = "actActivityid")
	private String actActivityid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "actStartDate")
	private Date actStartDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "actEndDate")
	private Date actEndDate;
	
	@Column(name = "actEmployee")
	private String actEmployee;
	
	@Column(name = "actActivityType")
	private String actActivityType;
	
	@Column(name = "actDescription")
	private String actDescription;
	
	@Column(name = "conFName")
	private String conFName;
	
	@Column(name = "conLName")
	private String conLName;
	
	@Column(name = "conName")
	private String conName; 
	
	@Column(name = "comName")
	private String comName;

	public String getActActivityid() {
		return actActivityid;
	}

	public void setActActivityid(String actActivityid) {
		this.actActivityid = actActivityid;
	}

	public Date getActStartDate() {
		return actStartDate;
	}

	public void setActStartDate(Date actStartDate) {
		this.actStartDate = actStartDate;
	}

	public Date getActEndDate() {
		return actEndDate;
	}

	public void setActEndDate(Date actEndDate) {
		this.actEndDate = actEndDate;
	}

	public String getActEmployee() {
		return actEmployee;
	}

	public void setActEmployee(String actEmployee) {
		this.actEmployee = actEmployee;
	}

	public String getActActivityType() {
		return actActivityType;
	}

	public void setActActivityType(String actActivityType) {
		this.actActivityType = actActivityType;
	}

	public String getActDescription() {
		return actDescription;
	}

	public void setActDescription(String actDescription) {
		this.actDescription = actDescription;
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

	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}
	
	
}
