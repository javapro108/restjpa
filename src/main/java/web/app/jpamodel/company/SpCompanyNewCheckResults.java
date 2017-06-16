package web.app.jpamodel.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SpCompanyNewCheckResults {
	@Id
	@Column(name = "comID", length = 10)
	private long comID;

	@Column(name = "comName", length = 50)
	private String comName;

	@Column(name = "comCity", length = 50)
	private String comCity;

	@Column(name = "comState", length = 2)
	private String comState;
	
	@Column(name = "comZip", length = 10)
	private String comZip;

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
		
}
