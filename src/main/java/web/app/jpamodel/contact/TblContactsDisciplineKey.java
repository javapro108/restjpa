package web.app.jpamodel.contact;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;


@Embeddable
public class TblContactsDisciplineKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -447679448144483289L;

	@Column(name="codContactID",length=18)
	private long codContactID;
		
	@Column(name="codDisciplineID",length=10)
	private String codDisciplineID;

	public long getCodContactID() {
		return codContactID;
	}

	public void setCodContactID(long codContactID) {
		this.codContactID = codContactID;
	}

	public String getCodDisciplineID() {
		return codDisciplineID;
	}

	public void setCodDisciplineID(String codDisciplineID) {
		this.codDisciplineID = codDisciplineID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;

		if (!(o instanceof TblContactsDisciplineKey))
			return false;

		TblContactsDisciplineKey that = (TblContactsDisciplineKey) o;

		if (Objects.equals(this.getCodContactID(),    that.getCodContactID())
		 && Objects.equals(this.getCodDisciplineID(), that.getCodDisciplineID())) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(getCodContactID(), getCodDisciplineID());
	}
	
}
