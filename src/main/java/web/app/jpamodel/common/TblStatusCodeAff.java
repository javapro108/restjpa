package web.app.jpamodel.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblStatusCodeAff", schema = "dbo")
public class TblStatusCodeAff {
	
	@Id
	@Column(name = "staAffID")
	private long staAffID;
	
	@Column(name = "staAffDesc", length = 50)
	private String staAffDesc;

	public long getStaAffID() {
		return staAffID;
	}

	public void setStaAffID(long staAffID) {
		this.staAffID = staAffID;
	}

	public String getStaAffDesc() {
		return staAffDesc;
	}

	public void setStaAffDesc(String staAffDesc) {
		this.staAffDesc = staAffDesc;
	}

}
