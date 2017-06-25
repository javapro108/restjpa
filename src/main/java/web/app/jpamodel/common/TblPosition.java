package web.app.jpamodel.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

@NamedStoredProcedureQuery(
		name="spPositionDropdown", 
		procedureName="spPositionDropdown", 
		resultClasses = {TblPosition.class}
	)
@Entity
@Table(name = "tblPosition", schema = "dbo")
public class TblPosition {

	@Id
	@Column(name="posID", length=10)	
	private String posID;
	
	@Column(name="posPosition", length=10)
	private String posPosition;

	
	public String getPosID() {
		return posID;
	}

	public void setPosID(String posID) {
		this.posID = posID;
	}

	public String getPosPosition() {
		return posPosition;
	}

	public void setPosPosition(String posPosition) {
		this.posPosition = posPosition;
	}
	
}
