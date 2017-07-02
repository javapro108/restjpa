package web.app.jpamodel.contact.sp;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@NamedStoredProcedureQuery(
		name="spContactComments", 
		procedureName="spContactComments", 
		parameters = {
		    @StoredProcedureParameter(name = "conID", mode=ParameterMode.IN, type = Long.class)
		},
		resultClasses = {SpContactCommentsResults.class}
	)
@Entity
public class SpContactCommentsResults {
	
	@Id
	@Column
	private String cocID;

	@Column
	private String cocContactID;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date cocDate;

	@Column
	private String cocUser;

	@Column
	private String cmdComment;

	public String getCocID() {
		return cocID;
	}

	public void setCocID(String cocID) {
		this.cocID = cocID;
	}

	public String getCocContactID() {
		return cocContactID;
	}

	public void setCocContactID(String cocContactID) {
		this.cocContactID = cocContactID;
	}

	public Date getCocDate() {
		return cocDate;
	}

	public void setCocDate(Date cocDate) {
		this.cocDate = cocDate;
	}

	public String getCocUser() {
		return cocUser;
	}

	public void setCocUser(String cocUser) {
		this.cocUser = cocUser;
	}

	public String getCmdComment() {
		return cmdComment;
	}

	public void setCmdComment(String cmdComment) {
		this.cmdComment = cmdComment;
	}
	
	
}
