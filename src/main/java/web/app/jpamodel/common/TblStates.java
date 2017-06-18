package web.app.jpamodel.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblStates", schema = "dbo")
public class TblStates {

	@Id
	@Column(name = "staAbbrev", length = 2)
	private String staAbbrev;

	@Column(name = "staState", length = 30)
	private String staState;

	public String getStaAbbrev() {
		return staAbbrev;
	}

	public void setStaAbbrev(String staAbbrev) {
		this.staAbbrev = staAbbrev;
	}

	public String getStaState() {
		return staState;
	}

	public void setStaState(String staState) {
		this.staState = staState;
	}	

}
