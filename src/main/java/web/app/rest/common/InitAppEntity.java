package web.app.rest.common;

import java.util.ArrayList;
import java.util.List;

import web.app.jpamodel.common.TblAffiliates;
import web.app.jpamodel.common.TblCountry;
import web.app.jpamodel.common.TblDiscipline;
import web.app.jpamodel.common.TblDistrict;
import web.app.jpamodel.common.TblPosition;
import web.app.jpamodel.common.TblPrefix;
import web.app.jpamodel.common.TblStates;
import web.app.jpamodel.common.TblStatusCodeAff;
import web.app.jpamodel.common.sp.SpRepDropDown;
import web.app.jpamodel.employee.SpEmpDistrictsResults;
import web.app.jpamodel.employee.TblEmployees;

public class InitAppEntity {
	
	private List<SpEmpDistrictsResults> empDistricts = new ArrayList<SpEmpDistrictsResults>();
	private List<TblDistrict> districts = new ArrayList<TblDistrict>();
	private List<TblStates> states = new ArrayList<TblStates>();
	private List<TblCountry> countries = new ArrayList<TblCountry>();
	private List<TblEmployees> employees = new ArrayList<TblEmployees>();
	private List<SpRepDropDown> repOpts = new ArrayList<SpRepDropDown>();
	private List<TblPrefix> prefixOpts = new ArrayList<TblPrefix>();
	private List<TblDiscipline> dispOpts = new ArrayList<TblDiscipline>();
	private List<TblPosition> posOpts = new ArrayList<TblPosition>();
	private List<TblAffiliates> empAffOpts = new ArrayList<TblAffiliates>();
	private List<TblAffiliates> affOptsAll = new ArrayList<TblAffiliates>();
	private List<TblStatusCodeAff> affStatus = new ArrayList<TblStatusCodeAff>();

	public List<SpEmpDistrictsResults> getEmpDistricts() {
		return empDistricts;
	}
	public void setEmpDistricts(List<SpEmpDistrictsResults> empDistricts) {
		this.empDistricts = empDistricts;
	}
	public List<TblDistrict> getDistricts() {
		return districts;
	}
	public void setDistricts(List<TblDistrict> districts) {
		this.districts = districts;
	}
	public List<TblStates> getStates() {
		return states;
	}
	public void setStates(List<TblStates> states) {
		this.states = states;
	}
	public List<TblCountry> getCountries() {
		return countries;
	}
	public void setCountries(List<TblCountry> countries) {
		this.countries = countries;
	}
	public List<TblEmployees> getEmployees() {
		return employees;
	}
	public void setEmployees(List<TblEmployees> employees) {
		this.employees = employees;
	}
	public List<SpRepDropDown> getRepOpts() {
		return repOpts;
	}
	public void setRepOpts(List<SpRepDropDown> repOpts) {
		this.repOpts = repOpts;
	}
	public List<TblPrefix> getPrefixOpts() {
		return prefixOpts;
	}
	public void setPrefixOpts(List<TblPrefix> prefixOpts) {
		this.prefixOpts = prefixOpts;
	}
	public List<TblDiscipline> getDispOpts() {
		return dispOpts;
	}
	public void setDispOpts(List<TblDiscipline> dispOpts) {
		this.dispOpts = dispOpts;
	}
	public List<TblPosition> getPosOpts() {
		return posOpts;
	}
	public void setPosOpts(List<TblPosition> posOpts) {
		this.posOpts = posOpts;
	}
	public List<TblAffiliates> getEmpAffOpts() {
		return empAffOpts;
	}
	public void setEmpAffOpts(List<TblAffiliates> empAffOpts) {
		this.empAffOpts = empAffOpts;
	}
	public List<TblAffiliates> getAffOptsAll() {
		return affOptsAll;
	}
	public void setAffOptsAll(List<TblAffiliates> affOptsAll) {
		this.affOptsAll = affOptsAll;
	}
	public List<TblStatusCodeAff> getAffStatus() {
		return affStatus;
	}
	public void setAffStatus(List<TblStatusCodeAff> affStatus) {
		this.affStatus = affStatus;
	}
	
}
