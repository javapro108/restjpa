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
		name="spContactView", 
		procedureName="spContactView", 
		parameters = {
		    @StoredProcedureParameter(name = "conID", mode=ParameterMode.IN, type = Long.class),
		    @StoredProcedureParameter(name = "empID", mode=ParameterMode.IN, type = String.class)
		},
		resultClasses = {SpContactViewResults.class}
	)
@Entity
public class SpContactViewResults {
	
	@Id
	@Column
	private String conName;
	
	@Column
	private String conFName;
	
	@Column
	private String conMI;
	
	@Column
	private String conLName;  
	
	@Column
	private String conAlias;
	
	@Column
	private String conCourtesy;
	
	@Column
	private String conTitle;
	
	@Column
	private String conAssistantName;
	
	@Column
	private String conAssistPhone;
	
	@Column
	private String conAssistExt;
	
	@Column
	private String conExt;
	
	@Column
	private String conDirectPhone;
	
	@Column
	private String conCellPhone;
	
	@Column
	private String conFaxNum;
	
	@Column
	private String conEmail;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date conRevisedDate;
	
	@Column
	private String conRevisedBy;
	
	@Column
	private String comPhone;
	
	@Column
	private String posPosition;
	
	@Column
	private String comName;
	
	@Column
	private String comAddress;
	
	@Column
	private String comAddress2;
	
	@Column
	private String comCity;
	
	@Column
	private String comState;
	
	@Column
	private String comZip;
	
	@Column
	private String comCountry;
	
	@Column
	private String comFax;
	
	@Column
	private String comTollFree;
	
	@Column
	private String comWeb;
	
	@Column
	private String comDeliveryAddress1;
	
	@Column
	private String comDeliveryAddress2;
	
	@Column
	private String comDeliveryCity;
	
	@Column
	private String comDeliveryState;
	
	@Column
	private String comDeliveryZip;
	
	@Column
	private String comDeliveryCountry;
	
	@Column
	private String comDeliveryDirections;
	
	@Column
	private String comMailAddress1;
	
	@Column
	private String comMailAddress2;
	
	@Column
	private String comMailCity;
	
	@Column
	private String comMailState;
	
	@Column
	private String comMailZip;
	
	@Column
	private String comMailCountry;
	
	@Column
	private String comDirectionComments;
	
	@Column
	private String conHomeAddress;
	
	@Column
	private String conHomeAddress2;
	
	@Column
	private String conHomeCity;
	
	@Column
	private String conHomeState;
	
	@Column
	private String conHomeZip;
	
	@Column
	private String conHomePhone;
	
	@Column
	private String conHomeEmail;
	
	@Column
	private String conHomeFax;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date conBirthday;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date conAnniversary;
	
	@Column
	private String conGuestName;
	
	@Column
	private String comDirections;
	
	@Column
	private String comID;
	
	@Column
	private String comDistrict;
	
	@Column
	private String terName;
	
	@Column
	private Boolean conInactive;
	
	@Column
	private String conCompanyID;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date conDate;
	
	@Column
	private String conCreatedBy;
	
	@Column
	private String conAssistEmail;

	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
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

	public String getConAlias() {
		return conAlias;
	}

	public void setConAlias(String conAlias) {
		this.conAlias = conAlias;
	}

	public String getConCourtesy() {
		return conCourtesy;
	}

	public void setConCourtesy(String conCourtesy) {
		this.conCourtesy = conCourtesy;
	}

	public String getConTitle() {
		return conTitle;
	}

	public void setConTitle(String conTitle) {
		this.conTitle = conTitle;
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

	public String getConExt() {
		return conExt;
	}

	public void setConExt(String conExt) {
		this.conExt = conExt;
	}

	public String getConDirectPhone() {
		return conDirectPhone;
	}

	public void setConDirectPhone(String conDirectPhone) {
		this.conDirectPhone = conDirectPhone;
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

	public String getComPhone() {
		return comPhone;
	}

	public void setComPhone(String comPhone) {
		this.comPhone = comPhone;
	}

	public String getPosPosition() {
		return posPosition;
	}

	public void setPosPosition(String posPosition) {
		this.posPosition = posPosition;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getComAddress() {
		return comAddress;
	}

	public void setComAddress(String comAddress) {
		this.comAddress = comAddress;
	}

	public String getComAddress2() {
		return comAddress2;
	}

	public void setComAddress2(String comAddress2) {
		this.comAddress2 = comAddress2;
	}

	public String getComCity() {
		return comCity;
	}

	public void setComCity(String comCity) {
		this.comCity = comCity;
	}

	public String getComState() {
		return comState;
	}

	public void setComState(String comState) {
		this.comState = comState;
	}

	public String getComZip() {
		return comZip;
	}

	public void setComZip(String comZip) {
		this.comZip = comZip;
	}

	public String getComCountry() {
		return comCountry;
	}

	public void setComCountry(String comCountry) {
		this.comCountry = comCountry;
	}

	public String getComFax() {
		return comFax;
	}

	public void setComFax(String comFax) {
		this.comFax = comFax;
	}

	public String getComTollFree() {
		return comTollFree;
	}

	public void setComTollFree(String comTollFree) {
		this.comTollFree = comTollFree;
	}

	public String getComWeb() {
		return comWeb;
	}

	public void setComWeb(String comWeb) {
		this.comWeb = comWeb;
	}

	public String getComDeliveryAddress1() {
		return comDeliveryAddress1;
	}

	public void setComDeliveryAddress1(String comDeliveryAddress1) {
		this.comDeliveryAddress1 = comDeliveryAddress1;
	}

	public String getComDeliveryAddress2() {
		return comDeliveryAddress2;
	}

	public void setComDeliveryAddress2(String comDeliveryAddress2) {
		this.comDeliveryAddress2 = comDeliveryAddress2;
	}

	public String getComDeliveryCity() {
		return comDeliveryCity;
	}

	public void setComDeliveryCity(String comDeliveryCity) {
		this.comDeliveryCity = comDeliveryCity;
	}

	public String getComDeliveryState() {
		return comDeliveryState;
	}

	public void setComDeliveryState(String comDeliveryState) {
		this.comDeliveryState = comDeliveryState;
	}

	public String getComDeliveryZip() {
		return comDeliveryZip;
	}

	public void setComDeliveryZip(String comDeliveryZip) {
		this.comDeliveryZip = comDeliveryZip;
	}

	public String getComDeliveryCountry() {
		return comDeliveryCountry;
	}

	public void setComDeliveryCountry(String comDeliveryCountry) {
		this.comDeliveryCountry = comDeliveryCountry;
	}

	public String getComDeliveryDirections() {
		return comDeliveryDirections;
	}

	public void setComDeliveryDirections(String comDeliveryDirections) {
		this.comDeliveryDirections = comDeliveryDirections;
	}

	public String getComMailAddress1() {
		return comMailAddress1;
	}

	public void setComMailAddress1(String comMailAddress1) {
		this.comMailAddress1 = comMailAddress1;
	}

	public String getComMailAddress2() {
		return comMailAddress2;
	}

	public void setComMailAddress2(String comMailAddress2) {
		this.comMailAddress2 = comMailAddress2;
	}

	public String getComMailCity() {
		return comMailCity;
	}

	public void setComMailCity(String comMailCity) {
		this.comMailCity = comMailCity;
	}

	public String getComMailState() {
		return comMailState;
	}

	public void setComMailState(String comMailState) {
		this.comMailState = comMailState;
	}

	public String getComMailZip() {
		return comMailZip;
	}

	public void setComMailZip(String comMailZip) {
		this.comMailZip = comMailZip;
	}

	public String getComMailCountry() {
		return comMailCountry;
	}

	public void setComMailCountry(String comMailCountry) {
		this.comMailCountry = comMailCountry;
	}

	public String getComDirectionComments() {
		return comDirectionComments;
	}

	public void setComDirectionComments(String comDirectionComments) {
		this.comDirectionComments = comDirectionComments;
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

	public String getConHomeEmail() {
		return conHomeEmail;
	}

	public void setConHomeEmail(String conHomeEmail) {
		this.conHomeEmail = conHomeEmail;
	}

	public String getConHomeFax() {
		return conHomeFax;
	}

	public void setConHomeFax(String conHomeFax) {
		this.conHomeFax = conHomeFax;
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

	public String getComDirections() {
		return comDirections;
	}

	public void setComDirections(String comDirections) {
		this.comDirections = comDirections;
	}

	public String getComID() {
		return comID;
	}

	public void setComID(String comID) {
		this.comID = comID;
	}

	public String getComDistrict() {
		return comDistrict;
	}

	public void setComDistrict(String comDistrict) {
		this.comDistrict = comDistrict;
	}

	public String getTerName() {
		return terName;
	}

	public void setTerName(String terName) {
		this.terName = terName;
	}

	public Boolean getConInactive() {
		return conInactive;
	}

	public void setConInactive(Boolean conInactive) {
		this.conInactive = conInactive;
	}

	public String getConCompanyID() {
		return conCompanyID;
	}

	public void setConCompanyID(String conCompanyID) {
		this.conCompanyID = conCompanyID;
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
