package web.app.jpamodel.contact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;


@NamedStoredProcedureQuery(
		name="spContactNewCheck", 
		procedureName="spContactNewCheck", 
		parameters = {
		    @StoredProcedureParameter(name = "conFName", mode=ParameterMode.IN, type = String.class),
		    @StoredProcedureParameter(name = "conLName", mode=ParameterMode.IN, type = String.class)
		},
		resultClasses = {SpContactNewCheckResults.class}
	)
@Entity
public class SpContactNewCheckResults {
	@Id
	@Column(name = "conID", length = 18)
	private long conID;
	
	@Column(name = "conFName", length = 30)
	private String conFName;
	
	@Column(name = "conLName", length = 30)
	private String conLName;
	
	@Column(name = "comName", length = 50)
	private String comName;

	public long getConID() {
		return conID;
	}

	public void setConID(long conID) {
		this.conID = conID;
	}

	public String getConFName() {
		return conFName;
	}

	public void setConFName(String conFName) {
		this.conFName = conFName;
	}

	public String getConLName() {
		return conLName;
	}

	public void setConLName(String conLName) {
		this.conLName = conLName;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}
	
	
	
}
