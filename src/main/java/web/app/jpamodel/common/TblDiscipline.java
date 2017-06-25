package web.app.jpamodel.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

@NamedStoredProcedureQuery(
		name="spDiscipline", 
		procedureName="spDiscipline", 
		resultClasses = {TblDiscipline.class}
	)
@Entity
@Table(name = "tblDiscipline", schema = "dbo")
public class TblDiscipline {
	
	@Id
	@Column(name = "dispCode", length = 10)
	private String dispCode;
	
	@Column(name = "dispName", length = 50)
	private String dispName;
	
	@Column(name = "dispInactive")
	private Boolean dispInactive;
	
	@Column(name = "sbs")
	private Boolean sbs;
	
	@Column(name = "dispMarketing")
	private Boolean dispMarketing;
	
	public String getDispCode() {
		return dispCode;
	}
	public void setDispCode(String dispCode) {
		this.dispCode = dispCode;
	}
	public String getDispName() {
		return dispName;
	}
	public void setDispName(String dispName) {
		this.dispName = dispName;
	}
	public Boolean getDispInactive() {
		return dispInactive;
	}
	public void setDispInactive(Boolean dispInactive) {
		this.dispInactive = dispInactive;
	}
	public Boolean getSbs() {
		return sbs;
	}
	public void setSbs(Boolean sbs) {
		this.sbs = sbs;
	}
	public Boolean getDispMarketing() {
		return dispMarketing;
	}
	public void setDispMarketing(Boolean dispMarketing) {
		this.dispMarketing = dispMarketing;
	}
	
	
	
}
