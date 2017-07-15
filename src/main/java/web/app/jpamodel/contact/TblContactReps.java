package web.app.jpamodel.contact;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;


@Entity
@IdClass(TblContactRepsKey.class)
@Table(name = "tblContactReps", schema = "dbo")
public class TblContactReps {

//	@EmbeddedId
//	private TblContactRepsKey key;
	
	@Id
	@Column(name = "corRepID", length = 3)
	private String corRepID;
	
	@Id
	@Column(name = "corAffialiateID", length = 4)
	private String corAffialiateID;
	
	@Id
	@Column(name = "corContactID", length = 18)
	private long corContactID;	

	@Column(name = "corStatus", length = 10)
	private String corStatus;
	
	@Basic(optional = true)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "corLastContact", nullable = true)
	private Date corLastContact;

	@Transient
	private String mode;	
	
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
	
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	
}
