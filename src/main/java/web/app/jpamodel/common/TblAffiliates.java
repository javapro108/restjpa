package web.app.jpamodel.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@NamedStoredProcedureQuery(
		name="spAffiliateDropdown", 
		procedureName="spAffiliateDropdown", 
		parameters = {
		    @StoredProcedureParameter(name = "empID", mode=ParameterMode.IN, type = String.class)
		},
		resultClasses = {TblAffiliates.class}
	)
@Entity
@Table(name = "tblAffiliates", schema = "dbo")
public class TblAffiliates {
	
	@Id
	@Column(name="affID", length=2)		
	public String affID;
	
	@Column(name="affName", length=100)
	public String affName;
	
	@Column(name="affInactive")
	public Boolean affInactive;
	
	@Column(name="affType", length=1)
	public String affType;

	public String getAffID() {
		return affID;
	}

	public void setAffID(String affID) {
		this.affID = affID;
	}

	public String getAffName() {
		return affName;
	}

	public void setAffName(String affName) {
		this.affName = affName;
	}

	public Boolean getAffInactive() {
		return affInactive;
	}

	public void setAffInactive(Boolean affInactive) {
		this.affInactive = affInactive;
	}

	public String getAffType() {
		return affType;
	}

	public void setAffType(String affType) {
		this.affType = affType;
	}
	
}
