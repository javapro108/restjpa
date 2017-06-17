package web.app.jpamodel.company.sp;

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
		name="spCompanyComments", 
		procedureName="spCompanyComments", 
		parameters = {
		    @StoredProcedureParameter(name = "comID", mode=ParameterMode.IN, type = Long.class)
		},
		resultClasses = {SpCompanyCommentsResults.class}
	)
@Entity
public class SpCompanyCommentsResults {

	@Id
	@Column(name = "cmcID", length = 18)
	private long cmcID;

	@Column(name = "cmcCompanyID", length = 10)
	private String cmcCompanyID;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "cmcDate")
	private Date cmcDate;

	@Column(name = "cmcUser", length = 10)
	private String cmcUser;

	@Column(name = "cmcComment", length = 500)
	private String cmcComment;

	@Column(name = "cmcPriority", length = 1)
	private String cmcPriority;

	public long getCmcID() {
		return cmcID;
	}

	public void setCmcID(long cmcID) {
		this.cmcID = cmcID;
	}

	public String getCmcCompanyID() {
		return cmcCompanyID;
	}

	public void setCmcCompanyID(String cmcCompanyID) {
		this.cmcCompanyID = cmcCompanyID;
	}

	public Date getCmcDate() {
		return cmcDate;
	}

	public void setCmcDate(Date cmcDate) {
		this.cmcDate = cmcDate;
	}

	public String getCmcUser() {
		return cmcUser;
	}

	public void setCmcUser(String cmcUser) {
		this.cmcUser = cmcUser;
	}

	public String getCmcComment() {
		return cmcComment;
	}

	public void setCmcComment(String cmcComment) {
		this.cmcComment = cmcComment;
	}

	public String getCmcPriority() {
		return cmcPriority;
	}

	public void setCmcPriority(String cmcPriority) {
		this.cmcPriority = cmcPriority;
	}
	
	
	
}
