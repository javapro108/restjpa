package web.app.jpamodel.contact;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TblContactAffiliatesKey implements Serializable { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2693060926759480797L;

	@Column(name="cafAffialiateID",length=2)
	private String cafAffialiateID;
	
	@Column(name="cafContactID",length=18)
	private long cafContactID;

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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;

		if (!(o instanceof TblContactAffiliatesKey))
			return false;

		TblContactAffiliatesKey that = (TblContactAffiliatesKey) o;

		if (Objects.equals(this.getCafContactID(),    that.getCafContactID())
		 && Objects.equals(this.getCafAffialiateID(), that.getCafAffialiateID())) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(getCafAffialiateID(), getCafContactID());
	}

	
}