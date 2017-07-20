package web.app.jpamodel.common;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "tblDistrict", schema = "dbo")
public class TblDistrict {

	@Id
	@Column(name = "disName", length = 3)
	private String disName;

	@Column(name = "disDescription", length = 100)
	private String disDescription;

	@Column(name = "disTerritory", length = 1)
	private String disTerritory;

	@Column(name = "disState", length = 10)
	private String disState;

	@Column(name = "disCity", length = 25)
	private String disCity;

	public String getDisName() {
		return disName;
	}

	public void setDisName(String disName) {
		this.disName = disName;
	}

	public String getDisDescription() {
		return disDescription;
	}

	public void setDisDescription(String disDescription) {
		this.disDescription = disDescription;
	}

	public String getDisTerritory() {
		return disTerritory;
	}

	public void setDisTerritory(String disTerritory) {
		this.disTerritory = disTerritory;
	}

	public String getDisState() {
		return disState;
	}

	public void setDisState(String disState) {
		this.disState = disState;
	}

	public String getDisCity() {
		return disCity;
	}

	public void setDisCity(String disCity) {
		this.disCity = disCity;
	}

}
