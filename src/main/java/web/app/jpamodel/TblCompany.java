package web.app.jpamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblCompany", schema="dbo")
public class TblCompany {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String comID;
	@Column
	private String comName;
	@Column
	private String comAlias;
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
	private String comWeb;
	@Column
	private String comPhone;
	@Column
	private String comFax;
	@Column
	private String comTollFree;
	@Column
	private String comDirections;
	@Column
	private String comRevisedDate;
	@Column
	private String comRevisedBy;
	@Column
	private String comDistrict;
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
	private String comInactive;
	@Column
	private String comOldID;
	@Column
	private String comDate;
	@Column
	private String comCreatedBy;
	@Column
	private String comSolomonID;
	
	public String getComID() {
		return comID;
	}
	public void setComID(String comID) {
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
	public String getComRevisedDate() {
		return comRevisedDate;
	}
	public void setComRevisedDate(String comRevisedDate) {
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
	public void setComDeliveryDirections(String comDeliveryDirection) {
		this.comDeliveryDirections = comDeliveryDirection;
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
	public String getComInactive() {
		return comInactive;
	}
	public void setComInactive(String comInactive) {
		this.comInactive = comInactive;
	}
	public String getComOldID() {
		return comOldID;
	}
	public void setComOldID(String comOldID) {
		this.comOldID = comOldID;
	}
	public String getComDate() {
		return comDate;
	}
	public void setComDate(String comDate) {
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
