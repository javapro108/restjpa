package web.app.jpamodel.company.sp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQuery(
		name="spCompanyJobs", 
		procedureName="spCompanyJobs", 
		parameters = {
		    @StoredProcedureParameter(name = "comID", mode=ParameterMode.IN, type = Long.class),
		    @StoredProcedureParameter(name = "empID", mode=ParameterMode.IN, type = String.class)
		},
		resultClasses = {SpCompanyJobsResults.class}
	)
@Entity
public class SpCompanyJobsResults {
	
	@Id
	@Column(name = "proID")
	private String proID;
	
	@Column(name = "proNumber")
	private String proNumber;
	
	@Column(name = "proName")
	private String proName;
	
	@Column(name = "proAlias")
	private String proAlias;
	
	@Column(name = "proAffCode")
	private String proAffCode;
	
	@Column(name = "proDistrictCode")
	private String proDistrictCode;
	
	@Column(name = "proRepCode")
	private String proRepCode;
	
	@Column(name = "proCity")
	private String proCity;
	
	@Column(name = "proState")
	private String proState;
	
	@Column(name = "proZip")
	private String proZip;
	
	//@Column(name = "comID")
	//private String comID;
	
	@Column(name = "proJobNumber")
	private String proJobNumber;
	
	@Column(name = "prcSelected")
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
