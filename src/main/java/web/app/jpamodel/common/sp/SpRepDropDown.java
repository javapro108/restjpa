package web.app.jpamodel.common.sp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;


@NamedStoredProcedureQuery(
		name="spRepDropDown", 
		procedureName="spRepDropDown", 
		resultClasses = {SpRepDropDown.class}
	)
@Entity
public class SpRepDropDown {
	
	@Id
	@Column
	private String empUserName;
	
	@Column
	private String empDescription;	
	
	@Column
	private String emptitle;
	
	@Column
	private String empEmail;

	public String getEmpUserName() {
		return empUserName;
	}

	public void setEmpUserName(String empUserName) {
		this.empUserName = empUserName;
	}

	public String getEmpDescription() {
		return empDescription;
	}

	public void setEmpDescription(String empDescription) {
		this.empDescription = empDescription;
	}

	public String getEmptitle() {
		return emptitle;
	}

	public void setEmptitle(String emptitle) {
		this.emptitle = emptitle;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

}
