package web.app.jpamodel.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblPrefix", schema = "dbo")
public class TblPrefix {
	
	@Id
	@Column(name="pfxPrefix", length=10)
	private String pfxPrefix;

	public String getPfxPrefix() {
		return pfxPrefix;
	}

	public void setPfxPrefix(String pfxPrefix) {
		this.pfxPrefix = pfxPrefix;
	}
	
}
