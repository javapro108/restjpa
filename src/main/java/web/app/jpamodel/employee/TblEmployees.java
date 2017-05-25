package web.app.jpamodel.employee;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;


@Entity
@Table(name = "tblEmployees", schema = "dbo")
public class TblEmployees {

	@Id
	@Column(name = "empUserName", length = 3)
	private String empUserName;

	@Column(name = "empName", length = 100)
	private String empName;

	@Column(name = "empTitle", length = 100)
	private String empTitle;

	@Column(name = "empExt", length = 5)
	private String empExt;

	@Column(name = "empDept", length = 10)
	private String empDept;

	@Column(name = "empRep")
	private Boolean empRep;

	@Column(name = "empInactive")
	private Boolean empInactive;

	@Column(name = "empPassword", length = 30)
	private String empPassword;

	@Column(name = "empEmail", length = 100)
	private String empEmail;

	@Column(name = "empMgr", length = 3)
	private String empMgr;

	@Column(name = "conid", length = 10)
	private Integer conid;

	@Column(name = "empAllAccess")
	private Boolean empAllAccess;

	public String getEmpUserName() {
		return empUserName;
	}

	public void setEmpUserName(String empUserName) {
		this.empUserName = empUserName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpTitle() {
		return empTitle;
	}

	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}

	public String getEmpExt() {
		return empExt;
	}

	public void setEmpExt(String empExt) {
		this.empExt = empExt;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public Boolean getEmpRep() {
		return empRep;
	}

	public void setEmpRep(Boolean empRep) {
		this.empRep = empRep;
	}

	public Boolean getEmpInactive() {
		return empInactive;
	}

	public void setEmpInactive(Boolean empInactive) {
		this.empInactive = empInactive;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpMgr() {
		return empMgr;
	}

	public void setEmpMgr(String empMgr) {
		this.empMgr = empMgr;
	}

	public Integer getConid() {
		return conid;
	}

	public void setConid(Integer conid) {
		this.conid = conid;
	}

	public Boolean getEmpAllAccess() {
		return empAllAccess;
	}

	public void setEmpAllAccess(Boolean empAllAccess) {
		this.empAllAccess = empAllAccess;
	}
}
