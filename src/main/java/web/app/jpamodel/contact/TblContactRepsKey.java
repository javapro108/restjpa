package web.app.jpamodel.contact;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TblContactRepsKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4938782926371584256L;

	@Column(name = "corRepID", length = 3)
	private String corRepID;

	@Column(name = "corAffialiateID", length = 4)
	private String corAffialiateID;

	@Column(name = "corContactID", length = 18)
	private long corContactID;

	public String getCorRepID() {
		return corRepID;
	}

	public void setCorRepID(String corRepID) {
		this.corRepID = corRepID;
	}

	public String getCorAffialiateID() {
		return corAffialiateID;
	}

	public void setCorAffialiateID(String corAffialiateID) {
		this.corAffialiateID = corAffialiateID;
	}

	public long getCorContactID() {
		return corContactID;
	}

	public void setCorContactID(long corContactID) {
		this.corContactID = corContactID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;

		if (!(o instanceof TblContactRepsKey))
			return false;

		TblContactRepsKey that = (TblContactRepsKey) o;

		if (Objects.equals(this.getCorRepID(), that.getCorRepID())
				&& Objects.equals(this.getCorContactID(), that.getCorContactID())
				&& Objects.equals(this.getCorAffialiateID(), that.getCorAffialiateID())) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(getCorRepID(), getCorAffialiateID(), getCorContactID());
	}

}
