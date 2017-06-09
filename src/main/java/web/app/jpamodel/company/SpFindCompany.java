package web.app.jpamodel.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.ParameterMode;

@NamedStoredProcedureQuery(
	    name="spFindCompany", 
	    procedureName="spFindCompany", 
	    parameters = {
	        @StoredProcedureParameter(name = "comName", mode=ParameterMode.IN, type = String.class),
	        @StoredProcedureParameter(name = "empID", mode=ParameterMode.IN, type = String.class),
	        @StoredProcedureParameter(name = "Inactive", mode=ParameterMode.IN, type = Boolean.class)
	    },
	    resultClasses = {SpFindCompany.class}
)
@Entity
public class SpFindCompany {
	@Id
	@Column(name = "comID", length = 10)
	private long comID;

	@Column(name = "comName", length = 50)
	private String comName;

	@Column(name = "comAlias", length = 100)
	private String comAlias;

	@Column(name = "comCity", length = 50)
	private String comCity;

	@Column(name = "comState", length = 2)
	private String comState;

	
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

	public String getComAlias() {
		return comAlias;
	}

	public void setComAlias(String comAlias) {
		this.comAlias = comAlias;
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
	
}
