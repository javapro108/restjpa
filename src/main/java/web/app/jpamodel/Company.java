package web.app.jpamodel;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name = "COMPANY")
public class Company {

	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "OBJECTTYPE", length = 10)
	private String objectType;

	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "NAME2", length = 50)
	private String name2;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "OBJECTID", referencedColumnName = "ID"),
				   @JoinColumn(name = "OBJECTTYPE", referencedColumnName = "OBJECTTYPE")
			     //@JoinColumn(name="OBJECTADDRESS.OBJECTTYPE", referencedColumnName = "'COMPANY'")
	})
	private List<ObjectAddress> addresses;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		name2 = name2;
	}

	public List<ObjectAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<ObjectAddress> addresses) {
		this.addresses = addresses;
	}

	public void addAddress(ObjectAddress objAddr) {
		this.addresses.add(objAddr);
	}

}