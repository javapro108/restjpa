package web.app.jpamodel.contact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;



@Entity
@Table(name = "tblContacts", schema = "dbo")
public class TblContacts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "conID", length = 18)
	private long conID;

	@Column(name = "conCompanyID", length = 19)
	private long conCompanyID;

	@Column(name = "conCourtesy", length = 10)
	private String conCourtesy;

	@Column(name = "conFName", length = 30)
	private String conFName;

	@Column(name = "conMI", length = 2)
	private String conMI;

	@Column(name = "conLName", length = 30)
	private String conLName;

	@Column(name = "conTitle", length = 50)
	private String conTitle;

	@Column(name = "conIM", length = 30)
	private String conIM;

	@Column(name = "conAlias", length = 30)
	private String conAlias;

	@Column(name = "conAssistantName", length = 50)
	private String conAssistantName;

	@Column(name = "conAssistPhone", length = 10)
	private String conAssistPhone;

	@Column(name = "conAssistExt", length = 10)
	private String conAssistExt;

	@Column(name = "conDirectPhone", length = 10)
	private String conDirectPhone;

	@Column(name = "conExt", length = 10)
	private String conExt;

	@Column(name = "conCellPhone", length = 10)
	private String conCellPhone;

	@Column(name = "conFaxNum", length = 10)
	private String conFaxNum;

	@Column(name = "conEmail", length = 50)
	private String conEmail;

	@Column(name = "conPosition", length = 10)
	private String conPosition;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "conBirthday")
	private Date conBirthday;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "conAnniversary")
	private Date conAnniversary;

	@Column(name = "conGuestName", length = 30)
	private String conGuestName;

	@Column(name = "conHomeAddress", length = 100)
	private String conHomeAddress;

	@Column(name = "conHomeAddress2", length = 100)
	private String conHomeAddress2;

	@Column(name = "conHomeCity", length = 30)
	private String conHomeCity;

	@Column(name = "conHomeState", length = 2)
	private String conHomeState;

	@Column(name = "conHomeZip", length = 12)
	private String conHomeZip;

	@Column(name = "conHomePhone", length = 10)
	private String conHomePhone;

	@Column(name = "conHomeFax", length = 10)
	private String conHomeFax;

	@Column(name = "conHomeEmail", length = 30)
	private String conHomeEmail;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "conRevisedDate")
	private Date conRevisedDate;

	@Column(name = "conRevisedBy", length = 10)
	private String conRevisedBy;

	@Column(name = "conInactive")
	private Boolean conInactive;

	@Column(name = "conOldCompID", length = 18)
	private long conOldCompID;

	@Column(name = "conOldID", length = 20)
	private String conOldID;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "conDate")
	private Date conDate;

	@Column(name = "conCreatedBy", length = 10)
	private String conCreatedBy;

	@Column(name = "conAssistEmail", length = 50)
	private String conAssistEmail;

	public long getConID() {
		return conID;
	}

	public void setConID(long conID) {
		this.conID = conID;
	}

	public long getConCompanyID() {
		return conCompanyID;
	}

	public void setConCompanyID(long conCompanyID) {
		this.conCompanyID = conCompanyID;
	}

	public String getConCourtesy() {
		return conCourtesy;
	}

	public void setConCourtesy(String conCourtesy) {
		this.conCourtesy = conCourtesy;
	}

	public String getConFName() {
		return conFName;
	}

	public void setConFName(String conFName) {
		this.conFName = conFName;
	}

	public String getConMI() {
		return conMI;
	}

	public void setConMI(String conMI) {
		this.conMI = conMI;
	}

	public String getConLName() {
		return conLName;
	}

	public void setConLName(String conLName) {
		this.conLName = conLName;
	}

	public String getConTitle() {
		return conTitle;
	}

	public void setConTitle(String conTitle) {
		this.conTitle = conTitle;
	}

	public String getConIM() {
		return conIM;
	}

	public void setConIM(String conIM) {
		this.conIM = conIM;
	}

	public String getConAlias() {
		return conAlias;
	}

	public void setConAlias(String conAlias) {
		this.conAlias = conAlias;
	}

	public String getConAssistantName() {
		return conAssistantName;
	}

	public void setConAssistantName(String conAssistantName) {
		this.conAssistantName = conAssistantName;
	}

	public String getConAssistPhone() {
		return conAssistPhone;
	}

	public void setConAssistPhone(String conAssistPhone) {
		this.conAssistPhone = conAssistPhone;
	}

	public String getConAssistExt() {
		return conAssistExt;
	}

	public void setConAssistExt(String conAssistExt) {
		this.conAssistExt = conAssistExt;
	}

	public String getConDirectPhone() {
		return conDirectPhone;
	}

	public void setConDirectPhone(String conDirectPhone) {
		this.conDirectPhone = conDirectPhone;
	}

	public String getConExt() {
		return conExt;
	}

	public void setConExt(String conExt) {
		this.conExt = conExt;
	}

	public String getConCellPhone() {
		return conCellPhone;
	}

	public void setConCellPhone(String conCellPhone) {
		this.conCellPhone = conCellPhone;
	}

	public String getConFaxNum() {
		return conFaxNum;
	}

	public void setConFaxNum(String conFaxNum) {
		this.conFaxNum = conFaxNum;
	}

	public String getConEmail() {
		return conEmail;
	}

	public void setConEmail(String conEmail) {
		this.conEmail = conEmail;
	}

	public String getConPosition() {
		return conPosition;
	}

	public void setConPosition(String conPosition) {
		this.conPosition = conPosition;
	}

	public Date getConBirthday() {
		return conBirthday;
	}

	public void setConBirthday(Date conBirthday) {
		this.conBirthday = conBirthday;
	}

	public Date getConAnniversary() {
		return conAnniversary;
	}

	public void setConAnniversary(Date conAnniversary) {
		this.conAnniversary = conAnniversary;
	}

	public String getConGuestName() {
		return conGuestName;
	}

	public void setConGuestName(String conGuestName) {
		this.conGuestName = conGuestName;
	}

	public String getConHomeAddress() {
		return conHomeAddress;
	}

	public void setConHomeAddress(String conHomeAddress) {
		this.conHomeAddress = conHomeAddress;
	}

	public String getConHomeAddress2() {
		return conHomeAddress2;
	}

	public void setConHomeAddress2(String conHomeAddress2) {
		this.conHomeAddress2 = conHomeAddress2;
	}

	public String getConHomeCity() {
		return conHomeCity;
	}

	public void setConHomeCity(String conHomeCity) {
		this.conHomeCity = conHomeCity;
	}

	public String getConHomeState() {
		return conHomeState;
	}

	public void setConHomeState(String conHomeState) {
		this.conHomeState = conHomeState;
	}

	public String getConHomeZip() {
		return conHomeZip;
	}

	public void setConHomeZip(String conHomeZip) {
		this.conHomeZip = conHomeZip;
	}

	public String getConHomePhone() {
		return conHomePhone;
	}

	public void setConHomePhone(String conHomePhone) {
		this.conHomePhone = conHomePhone;
	}

	public String getConHomeFax() {
		return conHomeFax;
	}

	public void setConHomeFax(String conHomeFax) {
		this.conHomeFax = conHomeFax;
	}

	public String getConHomeEmail() {
		return conHomeEmail;
	}

	public void setConHomeEmail(String conHomeEmail) {
		this.conHomeEmail = conHomeEmail;
	}

	public Date getConRevisedDate() {
		return conRevisedDate;
	}

	public void setConRevisedDate(Date conRevisedDate) {
		this.conRevisedDate = conRevisedDate;
	}

	public String getConRevisedBy() {
		return conRevisedBy;
	}

	public void setConRevisedBy(String conRevisedBy) {
		this.conRevisedBy = conRevisedBy;
	}

	public Boolean getConInactive() {
		return conInactive;
	}

	public void setConInactive(Boolean conInactive) {
		this.conInactive = conInactive;
	}

	public long getConOldCompID() {
		return conOldCompID;
	}

	public void setConOldCompID(long conOldCompID) {
		this.conOldCompID = conOldCompID;
	}

	public String getConOldID() {
		return conOldID;
	}

	public void setConOldID(String conOldID) {
		this.conOldID = conOldID;
	}

	public Date getConDate() {
		return conDate;
	}

	public void setConDate(Date conDate) {
		this.conDate = conDate;
	}

	public String getConCreatedBy() {
		return conCreatedBy;
	}

	public void setConCreatedBy(String conCreatedBy) {
		this.conCreatedBy = conCreatedBy;
	}

	public String getConAssistEmail() {
		return conAssistEmail;
	}

	public void setConAssistEmail(String conAssistEmail) {
		this.conAssistEmail = conAssistEmail;
	}
	
}
