package web.app.jpamodel.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@IdClass(TblEmpRolesKey.class)
@Table(name = "tblEmpRoles")
public class TblEmpRoles {
	
	@Id
	@Column(name = "emrRolID", length = 10)
	private String emrRolID;
	
	@Id
	@Column(name = "emrEmpUserName", length = 3)
	private String emrEmpUserName;

	@Transient
	private String mode;	
	
	public String getEmrRolID() {
		return emrRolID;
	}

	public void setEmrRolID(String emrRolID) {
		this.emrRolID = emrRolID;
	}

	public String getEmrEmpUserName() {
		return emrEmpUserName;
	}

	public void setEmrEmpUserName(String emrEmpUserName) {
		this.emrEmpUserName = emrEmpUserName;
	}
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}	
	
	
}
