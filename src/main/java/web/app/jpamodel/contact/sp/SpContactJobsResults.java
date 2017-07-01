package web.app.jpamodel.contact.sp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;


@NamedStoredProcedureQuery(
		name="spContactJobs", 
		procedureName="spContactJobs", 
		parameters = {
		    @StoredProcedureParameter(name = "comID", mode=ParameterMode.IN, type = Long.class),
		    @StoredProcedureParameter(name = "empID", mode=ParameterMode.IN, type = String.class)
		},
		resultClasses = {SpContactJobsResults.class}
	)
@Entity
public class SpContactJobsResults {
	
	@Id
	@Column
	private String proID;
	
	@Column
	private String proNumber;

	@Column
	private String proName;

	@Column
	private String proAlias;

	@Column
	private String proAffCode;

	@Column
	private String proDistrictCode;

	@Column
	private String proRepCode;

	@Column
	private String proCity;

	@Column
	private String proState;

	@Column
	private String proZip;

	@Column
	private String prcContactID;

	@Column
	private String comName;

	@Column
	private String proJobNumber; 

	@Column
	private String prcSelected;


	public String getProID() {
		return proID;
	}

	public void setProID(String proID) {
		this.proID = proID;
	}

	public String getProNumber() {
		return proNumber;
	}

	public void setProNumber(String proNumber) {
		this.proNumber = proNumber;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProAlias() {
		return proAlias;
	}

	public void setProAlias(String proAlias) {
		this.proAlias = proAlias;
	}

	public String getProAffCode() {
		return proAffCode;
	}

	public void setProAffCode(String proAffCode) {
		this.proAffCode = proAffCode;
	}

	public String getProDistrictCode() {
		return proDistrictCode;
	}

	public void setProDistrictCode(String proDistrictCode) {
		this.proDistrictCode = proDistrictCode;
	}

	public String getProRepCode() {
		return proRepCode;
	}

	public void setProRepCode(String proRepCode) {
		this.proRepCode = proRepCode;
	}

	public String getProCity() {
		return proCity;
	}

	public void setProCity(String proCity) {
		this.proCity = proCity;
	}

	public String getProState() {
		return proState;
	}

	public void setProState(String proState) {
		this.proState = proState;
	}

	public String getProZip() {
		return proZip;
	}

	public void setProZip(String proZip) {
		this.proZip = proZip;
	}

	public String getPrcContactID() {
		return prcContactID;
	}

	public void setPrcContactID(String prcContactID) {
		this.prcContactID = prcContactID;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getProJobNumber() {
		return proJobNumber;
	}

	public void setProJobNumber(String proJobNumber) {
		this.proJobNumber = proJobNumber;
	}

	public String getPrcSelected() {
		return prcSelected;
	}

	public void setPrcSelected(String prcSelected) {
		this.prcSelected = prcSelected;
	}
		
}
