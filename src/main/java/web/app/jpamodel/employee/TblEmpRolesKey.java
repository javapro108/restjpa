package web.app.jpamodel.employee;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import web.app.jpamodel.ObjectAddressKey;

@Embeddable
public class TblEmpRolesKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4939198757604354065L;

	
	@Column(name = "emrRolID", length = 10)
	private String emrRolID;

	@Column(name = "emrEmpUserName", length = 3)
	private String emrEmpUserName;

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

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;

		if (!(o instanceof TblEmpRolesKey))
			return false;

		TblEmpRolesKey that = (TblEmpRolesKey) o;

		if (Objects.equals(this.getEmrRolID(), that.getEmrRolID())
				&& Objects.equals(this.getEmrEmpUserName(), that.getEmrEmpUserName())) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(getEmrRolID(), getEmrEmpUserName());
	}

}
