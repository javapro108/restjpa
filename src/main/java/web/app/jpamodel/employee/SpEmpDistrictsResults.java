package web.app.jpamodel.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;


@NamedStoredProcedureQuery(
		name="spEmpDistricts", 
		procedureName="spEmpDistricts", 
		parameters = {
				@StoredProcedureParameter(name = "emp", mode=ParameterMode.IN, type = String.class)
		 	},
		resultClasses = {SpEmpDistrictsResults.class}
	)
@Entity
public class SpEmpDistrictsResults {
	
	@Column
	private String emdEmpUsername;
	
	@Id
	@Column
	private String emdDisID; 
	
	@Column	
	private String disDescription;
	
	public String getEmdEmpUsername() {
		return emdEmpUsername;
	}
	public void setEmdEmpUsername(String emdEmpUsername) {
		this.emdEmpUsername = emdEmpUsername;
	}

	public String getEmdDisID() {
		return emdDisID;
	}
	public void setEmdDisID(String emdDisID) {
		this.emdDisID = emdDisID;
	}

	public String getDisDescription() {
		return disDescription;
	}
	public void setDisDescription(String disDescription) {
		this.disDescription = disDescription;
	}
}
