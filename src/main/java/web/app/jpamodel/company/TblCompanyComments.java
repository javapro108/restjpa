package web.app.jpamodel.company;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "tblCompanyComments", schema = "dbo")
public class TblCompanyComments {

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

	@Column(name = "cmcPriority")
	private Boolean cmcPriority;

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

	public Boolean getCmcPriority() {
		return cmcPriority;
	}

	public void setCmcPriority(Boolean cmcPriority) {
		this.cmcPriority = cmcPriority;
	}
}
