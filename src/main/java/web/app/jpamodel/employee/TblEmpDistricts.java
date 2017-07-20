package web.app.jpamodel.employee;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import web.app.jpamodel.contact.TblContactRepsKey;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@IdClass(TblEmpDistrictsKey.class)
@Table(name = "tblEmpDistricts", schema = "dbo")
public class TblEmpDistricts {

	@Id
	@Column(name = "emdEmpUserName", length = 3)
	private String emdEmpUserName;
	
	@Id
	@Column(name = "emdDisID", length = 3)
	private String emdDisID;

	@Transient
	private String mode;	

	
	public String getEmdEmpUserName() {
		return emdEmpUserName;
	}
	
	public void setEmdEmpUserName(String emdEmpUserName) {
		this.emdEmpUserName = emdEmpUserName;
	}
	
	public String getEmdDisID() {
		return emdDisID;
	}
	
	public void setEmdDisID(String emdDisID) {
		this.emdDisID = emdDisID;
	}
	
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	
}
