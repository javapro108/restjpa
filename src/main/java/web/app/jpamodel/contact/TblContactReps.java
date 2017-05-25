package web.app.jpamodel.contact;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;


@Entity
@Table(name = "tblContactReps", schema = "dbo")
public class TblContactReps {

	@EmbeddedId
	private TblContactRepsKey key;

	@Column(name = "corStatus", length = 10)
	private String corStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "corLastContact")
	private Date corLastContact;

	public TblContactRepsKey getKey() {
		return key;
	}

	public void setKey(TblContactRepsKey key) {
		this.key = key;
	}

	public String getCorStatus() {
		return corStatus;
	}

	public void setCorStatus(String corStatus) {
		this.corStatus = corStatus;
	}

	public Date getCorLastContact() {
		return corLastContact;
	}

	public void setCorLastContact(Date corLastContact) {
		this.corLastContact = corLastContact;
	}
	
	
}
