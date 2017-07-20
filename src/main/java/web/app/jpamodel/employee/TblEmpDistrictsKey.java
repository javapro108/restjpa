package web.app.jpamodel.employee;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class TblEmpDistrictsKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8002975265389210549L;

	@Column(name = "emdEmpUserName", length = 3)
	private String emdEmpUserName;

	@Column(name = "emdDisID", length = 3)
	private String emdDisID;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;

		if (!(o instanceof TblEmpDistrictsKey))
			return false;

		TblEmpDistrictsKey that = (TblEmpDistrictsKey) o;

		if (Objects.equals(this.getEmdEmpUserName(), that.getEmdEmpUserName())
				&& Objects.equals(this.getEmdDisID(), that.getEmdDisID())) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(getEmdEmpUserName(), getEmdDisID());
	}	
	
}
