package web.app.jpamodel;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "tblCompany") //, schema = "dbo")
public class TblCompany{

@Id
@Column(name="comID")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long comID;

public long getComID() {
     return comID;
}

public void setComID(long comID) {
     this.comID = comID;
}



@Column(name="comName",length=50)
private String comName;

public String getComName() {
     return comName;
}

public void setComName(String comName) {
     this.comName = comName;
}



@Column(name="comAlias",length=100)
private String comAlias;

public String getComAlias() {
     return comAlias;
}

public void setComAlias(String comAlias) {
     this.comAlias = comAlias;
}



@Column(name="comAddress",length=255)
private String comAddress;

public String getComAddress() {
     return comAddress;
}

public void setComAddress(String comAddress) {
     this.comAddress = comAddress;
}



@Column(name="comAddress2",length=255)
private String comAddress2;

public String getComAddress2() {
     return comAddress2;
}

public void setComAddress2(String comAddress2) {
     this.comAddress2 = comAddress2;
}



@Column(name="comCity",length=50)
private String comCity;

public String getComCity() {
     return comCity;
}

public void setComCity(String comCity) {
     this.comCity = comCity;
}



@Column(name="comState",length=2)
private String comState;

public String getComState() {
     return comState;
}

public void setComState(String comState) {
     this.comState = comState;
}



@Column(name="comZip",length=10)
private String comZip;

public String getComZip() {
     return comZip;
}

public void setComZip(String comZip) {
     this.comZip = comZip;
}



@Column(name="comCountry",length=3)
private String comCountry;

public String getComCountry() {
     return comCountry;
}

public void setComCountry(String comCountry) {
     this.comCountry = comCountry;
}



@Column(name="comWeb",length=100)
private String comWeb;

public String getComWeb() {
     return comWeb;
}

public void setComWeb(String comWeb) {
     this.comWeb = comWeb;
}



@Column(name="comPhone",length=10)
private String comPhone;

public String getComPhone() {
     return comPhone;
}

public void setComPhone(String comPhone) {
     this.comPhone = comPhone;
}



@Column(name="comFax",length=10)
private String comFax;

public String getComFax() {
     return comFax;
}

public void setComFax(String comFax) {
     this.comFax = comFax;
}



@Column(name="comTollFree",length=10)
private String comTollFree;

public String getComTollFree() {
     return comTollFree;
}

public void setComTollFree(String comTollFree) {
     this.comTollFree = comTollFree;
}



@Column(name="comDirections",length=500)
private String comDirections;

public String getComDirections() {
     return comDirections;
}

public void setComDirections(String comDirections) {
     this.comDirections = comDirections;
}



@Column(name="comRevisedDate",length=8)
private String comRevisedDate;

public String getComRevisedDate() {
     return comRevisedDate;
}

public void setComRevisedDate(String comRevisedDate) {
     this.comRevisedDate = comRevisedDate;
}



@Column(name="comRevisedBy",length=10)
private String comRevisedBy;

public String getComRevisedBy() {
     return comRevisedBy;
}

public void setComRevisedBy(String comRevisedBy) {
     this.comRevisedBy = comRevisedBy;
}



@Column(name="comDistrict",length=5)
private String comDistrict;

public String getComDistrict() {
     return comDistrict;
}

public void setComDistrict(String comDistrict) {
     this.comDistrict = comDistrict;
}



@Column(name="comDeliveryAddress1",length=255)
private String comDeliveryAddress1;

public String getComDeliveryAddress1() {
     return comDeliveryAddress1;
}

public void setComDeliveryAddress1(String comDeliveryAddress1) {
     this.comDeliveryAddress1 = comDeliveryAddress1;
}



@Column(name="comDeliveryAddress2",length=255)
private String comDeliveryAddress2;

public String getComDeliveryAddress2() {
     return comDeliveryAddress2;
}

public void setComDeliveryAddress2(String comDeliveryAddress2) {
     this.comDeliveryAddress2 = comDeliveryAddress2;
}



@Column(name="comDeliveryCity",length=50)
private String comDeliveryCity;

public String getComDeliveryCity() {
     return comDeliveryCity;
}

public void setComDeliveryCity(String comDeliveryCity) {
     this.comDeliveryCity = comDeliveryCity;
}



@Column(name="comDeliveryState",length=2)
private String comDeliveryState;

public String getComDeliveryState() {
     return comDeliveryState;
}

public void setComDeliveryState(String comDeliveryState) {
     this.comDeliveryState = comDeliveryState;
}



@Column(name="comDeliveryZip",length=10)
private String comDeliveryZip;

public String getComDeliveryZip() {
     return comDeliveryZip;
}

public void setComDeliveryZip(String comDeliveryZip) {
     this.comDeliveryZip = comDeliveryZip;
}



@Column(name="comDeliveryCountry",length=3)
private String comDeliveryCountry;

public String getComDeliveryCountry() {
     return comDeliveryCountry;
}

public void setComDeliveryCountry(String comDeliveryCountry) {
     this.comDeliveryCountry = comDeliveryCountry;
}



@Column(name="comDeliveryDirections",length=500)
private String comDeliveryDirections;

public String getComDeliveryDirections() {
     return comDeliveryDirections;
}

public void setComDeliveryDirections(String comDeliveryDirections) {
     this.comDeliveryDirections = comDeliveryDirections;
}



@Column(name="comMailAddress1",length=255)
private String comMailAddress1;

public String getComMailAddress1() {
     return comMailAddress1;
}

public void setComMailAddress1(String comMailAddress1) {
     this.comMailAddress1 = comMailAddress1;
}



@Column(name="comMailAddress2",length=255)
private String comMailAddress2;

public String getComMailAddress2() {
     return comMailAddress2;
}

public void setComMailAddress2(String comMailAddress2) {
     this.comMailAddress2 = comMailAddress2;
}



@Column(name="comMailCity",length=50)
private String comMailCity;

public String getComMailCity() {
     return comMailCity;
}

public void setComMailCity(String comMailCity) {
     this.comMailCity = comMailCity;
}



@Column(name="comMailState",length=2)
private String comMailState;

public String getComMailState() {
     return comMailState;
}

public void setComMailState(String comMailState) {
     this.comMailState = comMailState;
}



@Column(name="comMailZip",length=10)
private String comMailZip;

public String getComMailZip() {
     return comMailZip;
}

public void setComMailZip(String comMailZip) {
     this.comMailZip = comMailZip;
}



@Column(name="comMailCountry",length=3)
private String comMailCountry;

public String getComMailCountry() {
     return comMailCountry;
}

public void setComMailCountry(String comMailCountry) {
     this.comMailCountry = comMailCountry;
}



@Column(name="comDirectionComments",length=500)
private String comDirectionComments;

public String getComDirectionComments() {
     return comDirectionComments;
}

public void setComDirectionComments(String comDirectionComments) {
     this.comDirectionComments = comDirectionComments;
}



@Column(name="comInactive",length=1)
private String comInactive;

public String getComInactive() {
     return comInactive;
}

public void setComInactive(String comInactive) {
     this.comInactive = comInactive;
}



@Column(name="comOldID")
private long comOldID;

public long getComOldID() {
     return comOldID;
}

public void setComOldID(long comOldID) {
     this.comOldID = comOldID;
}



@Column(name="comDate",length=8)
private String comDate;

public String getComDate() {
     return comDate;
}

public void setComDate(String comDate) {
     this.comDate = comDate;
}



@Column(name="comCreatedBy",length=10)
private String comCreatedBy;

public String getComCreatedBy() {
     return comCreatedBy;
}

public void setComCreatedBy(String comCreatedBy) {
     this.comCreatedBy = comCreatedBy;
}



@Column(name="comSolomonID",length=5)
private String comSolomonID;

public String getComSolomonID() {
     return comSolomonID;
}

public void setComSolomonID(String comSolomonID) {
     this.comSolomonID = comSolomonID;
}


}
