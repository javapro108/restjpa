package web.app.jpamodel.contact;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@IdClass(TblContactAffiliatesKey.class)
@Table(name = "tblContactAffiliates", schema = "dbo")
public class TblContactAffiliates {

	//@EmbeddedId
	//private TblContactAffiliatesKey key;

	@Id
	@Column(name="cafAffialiateID",length=2)
	private String cafAffialiateID;
	
	@Id
	@Column(name="cafContactID",length=18)
	private long cafContactID;

	@Column(name = "cafStatus", length = 10)
	private Integer cafStatus;

	@Column(name = "cafstatus2", length = 10)
	private String cafstatus2;

	
	@Transient
	private String mode;
	
	
	public String getCafAffialiateID() {
		return cafAffialiateID;
	}

	public void setCafAffialiateID(String cafAffialiateID) {
		this.cafAffialiateID = cafAffialiateID;
	}

	public long getCafContactID() {
		return cafContactID;
	}

	public void setCafContactID(long cafContactID) {
		this.cafContactID = cafContactID;
	}
	

	public Integer getCafStatus() {
		return cafStatus;
	}

	public void setCafStatus(Integer cafStatus) {
		this.cafStatus = cafStatus;
	}

	public String getCafstatus2() {
		return cafstatus2;
	}

	public void setCafstatus2(String cafstatus2) {
		this.cafstatus2 = cafstatus2;
	}
	
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	

}
