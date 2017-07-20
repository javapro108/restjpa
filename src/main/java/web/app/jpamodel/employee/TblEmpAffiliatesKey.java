package web.app.jpamodel.employee;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TblEmpAffiliatesKey implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -6699598599290872306L;

	@Column(name = "emaEmpUserName", length = 3)
	private String emaEmpUserName;

	@Column(name = "emaAffID", length = 2)
	private String emaAffID;

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

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;

		if (!(o instanceof TblEmpAffiliatesKey))
			return false;

		TblEmpAffiliatesKey that = (TblEmpAffiliatesKey) o;

		if (Objects.equals(this.getEmaEmpUserName(), that.getEmaEmpUserName())
				&& Objects.equals(this.getEmaAffID(), that.getEmaAffID())) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(getEmaEmpUserName(), getEmaAffID());
	}

}
