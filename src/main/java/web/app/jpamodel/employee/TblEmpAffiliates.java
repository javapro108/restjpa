package web.app.jpamodel.employee;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Column;

@Entity
@IdClass(TblEmpAffiliatesKey.class)
@Table(name = "tblEmpAffiliates", schema = "dbo")
public class TblEmpAffiliates {
	
	@Id
	@Column(name = "emaEmpUserName", length = 3)
	private String emaEmpUserName;
	
	@Id
	@Column(name = "emaAffID", length = 2)
	private String emaAffID;
	
	@Transient
	private String mode;	
	
	public String getEmaEmpUserName() {
		return emaEmpUserName;
	}
	public void setEmaEmpUserName(String emaEmpUserName) {
		this.emaEmpUserName = emaEmpUserName;
	}
	
	public String getEmaAffID() {
		return emaAffID;
	}
	public void setEmaAffID(String emaAffID) {
		this.emaAffID = emaAffID;
	}
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
}
