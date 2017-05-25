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
@Table(name = "tblCompany", schema = "dbo")
public class TblCompany {

	@Id
	@Column(name = "comID", length = 10)
	private long comID;

	@Column(name = "comName", length = 50)
	private String comName;

	@Column(name = "comAlias", length = 100)
	private String comAlias;

	@Column(name = "comAddress", length = 255)
	private String comAddress;

	@Column(name = "comAddress2", length = 255)
	private String comAddress2;

	@Column(name = "comCity", length = 50)
	private String comCity;

	@Column(name = "comState", length = 2)
	private String comState;

	@Column(name = "comZip", length = 10)
	private String comZip;

	@Column(name = "comCountry", length = 3)
	private String comCountry;

	@Column(name = "comWeb", length = 100)
	private String comWeb;

	@Column(name = "comPhone", length = 10)
	private String comPhone;

	@Column(name = "comFax", length = 10)
	private String comFax;

	@Column(name = "comTollFree", length = 10)
	private String comTollFree;

	@Column(name = "comDirections", length = 500)
	private String comDirections;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "comRevisedDate")
	private Date comRevisedDate;

	@Column(name = "comRevisedBy", length = 10)
	private String comRevisedBy;

	@Column(name = "comDistrict", length = 5)
	private String comDistrict;

	@Column(name = "comDeliveryAddress1", length = 255)
	private String comDeliveryAddress1;

	@Column(name = "comDeliveryAddress2", length = 255)
	private String comDeliveryAddress2;

	@Column(name = "comDeliveryCity", length = 50)
	private String comDeliveryCity;

	@Column(name = "comDeliveryState", length = 2)
	private String comDeliveryState;

	@Column(name = "comDeliveryZip", length = 10)
	private String comDeliveryZip;

	@Column(name = "comDeliveryCountry", length = 3)
	private String comDeliveryCountry;

	@Column(name = "comDeliveryDirections", length = 500)
	private String comDeliveryDirections;

	@Column(name = "comMailAddress1", length = 255)
	private String comMailAddress1;

	@Column(name = "comMailAddress2", length = 255)
	private String comMailAddress2;

	@Column(name = "comMailCity", length = 50)
	private String comMailCity;

	@Column(name = "comMailState", length = 2)
	private String comMailState;

	@Column(name = "comMailZip", length = 10)
	private String comMailZip;

	@Column(name = "comMailCountry", length = 3)
	private String comMailCountry;

	@Column(name = "comDirectionComments", length = 500)
	private String comDirectionComments;

	@Column(name = "comInactive")
	private Boolean comInactive;

	@Column(name = "comOldID", length = 18)
	private long comOldID;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "comDate")
	private Date comDate;

	@Column(name = "comCreatedBy", length = 10)
	private String comCreatedBy;

	@Column(name = "comSolomonID", length = 5)
	private String comSolomonID;

	public long getComID() {
		return comID;
	}

	public void setComID(long comID) {
		this.comID = comID;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getComAlias() {
		return comAlias;
	}

	public void setComAlias(String comAlias) {
		this.comAlias = comAlias;
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

	public String getComWeb() {
		return comWeb;
	}

	public void setComWeb(String comWeb) {
		this.comWeb = comWeb;
	}

	public String getComPhone() {
		return comPhone;
	}

	public void setComPhone(String comPhone) {
		this.comPhone = comPhone;
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

	public String getComDirections() {
		return comDirections;
	}

	public void setComDirections(String comDirections) {
		this.comDirections = comDirections;
	}

	public Date getComRevisedDate() {
		return comRevisedDate;
	}

	public void setComRevisedDate(Date comRevisedDate) {
		this.comRevisedDate = comRevisedDate;
	}

	public String getComRevisedBy() {
		return comRevisedBy;
	}

	public void setComRevisedBy(String comRevisedBy) {
		this.comRevisedBy = comRevisedBy;
	}

	public String getComDistrict() {
		return comDistrict;
	}

	public void setComDistrict(String comDistrict) {
		this.comDistrict = comDistrict;
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

	public Boolean getComInactive() {
		return comInactive;
	}

	public void setComInactive(Boolean comInactive) {
		this.comInactive = comInactive;
	}

	public long getComOldID() {
		return comOldID;
	}

	public void setComOldID(long comOldID) {
		this.comOldID = comOldID;
	}

	public Date getComDate() {
		return comDate;
	}

	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}

	public String getComCreatedBy() {
		return comCreatedBy;
	}

	public void setComCreatedBy(String comCreatedBy) {
		this.comCreatedBy = comCreatedBy;
	}

	public String getComSolomonID() {
		return comSolomonID;
	}

	public void setComSolomonID(String comSolomonID) {
		this.comSolomonID = comSolomonID;
	}
}
