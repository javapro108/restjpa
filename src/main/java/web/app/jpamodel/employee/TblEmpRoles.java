package web.app.jpamodel.employee;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tblEmpRoles")
public class TblEmpRoles {

	@EmbeddedId
	private TblEmpRolesKey key;

	public TblEmpRolesKey getKey() {
		return key;
	}

	public void setKey(TblEmpRolesKey key) {
		this.key = key;
	}
	
}
