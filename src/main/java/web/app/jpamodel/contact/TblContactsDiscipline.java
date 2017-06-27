package web.app.jpamodel.contact;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Column;

@Entity
@IdClass(TblContactsDisciplineKey.class)
@Table(name = "tblContactsDiscipline", schema = "dbo")
public class TblContactsDiscipline {

	// @EmbeddedId
	// private TblContactsDisciplineKey key;
	@Id
	@Column(name = "codContactID", length = 18)
	private long codContactID;

	@Id
	@Column(name = "codDisciplineID", length = 10)
	private String codDisciplineID;

	@Transient
	private String mode;	
	
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

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}


	
}
