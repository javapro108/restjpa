package web.app.jpamodel.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblCountry", schema = "dbo")
public class TblCountry {

	@Id
	@Column(name = "couID", length = 3)
	private String couID;

	@Column(name = "couCountry", length = 100)
	private String couCountry;

	
	public String getCouID() {
		return couID;
	}

	public void setCouID(String couID) {
		this.couID = couID;
	}

	public String getCouCountry() {
		return couCountry;
	}

	public void setCouCountry(String couCountry) {
		this.couCountry = couCountry;
	}

}
