package web.app.jpamodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.EmbeddedId;
import javax.persistence.Column;

@Entity
@Table(name = "OBJECTADDRESS")
public class ObjectAddress {

	@EmbeddedId
    private ObjectAddressKey addressKey;

	@Transient
	private String addrType;
	
	@Column(name = "FIRSTNAME", length = 50)
	private String firstName;

	@Column(name = "MIDDLENAME", length = 50)
	private String middleName;

	@Column(name = "LASTNAME", length = 50)
	private String lastName;

	@Column(name = "STREET1", length = 50)
	private String street1;

	@Column(name = "STREET2", length = 50)
	private String street2;

	@Column(name = "STREET3", length = 50)
	private String street3;

	@Column(name = "HOUSENO", length = 20)
	private String houseNo;

	@Column(name = "BUILDINGNO", length = 30)
	private String buildingNo;

	@Column(name = "CITY", length = 30)
	private String city;

	@Column(name = "POSTCODE", length = 15)
	private String postCode;

	@Column(name = "REGION", length = 30)
	private String region;

	@Column(name = "STATE", length = 40)
	private String state;

	@Column(name = "COUNTRY", length = 40)
	private String country;

	@Column(name = "PHONE", length = 20)
	private String phone;

	/* Getters and Setters */

	public ObjectAddressKey getAddressKey() {
		return addressKey;
	}

	public void setAddressKey(ObjectAddressKey addressKey) {
		this.addressKey = addressKey;
	}

	public String getAddrType() {
		return addrType;
	}

	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getStreet3() {
		return street3;
	}

	public void setStreet3(String street3) {
		this.street3 = street3;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
