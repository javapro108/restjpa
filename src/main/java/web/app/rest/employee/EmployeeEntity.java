package web.app.rest.employee;

import java.util.List;

import web.app.jpamodel.employee.TblEmpAffiliates;
import web.app.jpamodel.employee.TblEmpDistricts;
import web.app.jpamodel.employee.TblEmpRoles;
import web.app.jpamodel.employee.TblEmployees;
import web.app.rest.BaseEntity;

public class EmployeeEntity extends BaseEntity {

	TblEmployees employee = null;
	private List<TblEmpAffiliates> empAffiliates = null;
	private List<TblEmpDistricts> empDistricts = null;
	private List<TblEmpRoles> empRoles = null;

	public TblEmployees getEmployee() {
		return employee;
	}

	public void setEmployee(TblEmployees employee) {
		this.employee = employee;
	}

	public List<TblEmpAffiliates> getEmpAffiliates() {
		return empAffiliates;
	}
	
	public void setEmpAffiliates(List<TblEmpAffiliates> empAffiliates) {
		this.empAffiliates = empAffiliates;
	}
	
	public List<TblEmpDistricts> getEmpDistricts() {
		return empDistricts;
	}
	
	public void setEmpDistricts(List<TblEmpDistricts> empDistricts) {
		this.empDistricts = empDistricts;
	}
	
	public List<TblEmpRoles> getEmpRoles() {
		return empRoles;
	}
	
	public void setEmpRoles(List<TblEmpRoles> empRoles) {
		this.empRoles = empRoles;
	}
	
}
