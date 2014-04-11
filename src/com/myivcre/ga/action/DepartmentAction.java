package com.myivcre.ga.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myivcre.ga.model.Department;
import com.myivcre.ga.model.Organization;

@Component("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction {
	private String name;
	private String remarks;
	private int organizationId;
	private List<Organization> organizationList;
	private Department department;
	public String list(){
		this.list=this.baseService.getByHal("from department");
		return "success";
	}
	public String input(){
		this.department=(Department) this.baseService.get(Department.class, id);
		this.organizationList=this.baseService.getByHal("from organization");
		return "success";
	}
	public String delete(){
		this.department=(Department) this.baseService.get(Department.class, id);
		this.baseService.delete(this.department);
		return "list";
	}
	public String add(){
		this.department=new Department();
		this.department.setName(name);
		this.department.setRemarks(remarks);
		Organization organization =(Organization)this.baseService.get(Organization.class, organizationId);
		this.department.setOrganization(organization);
		this.baseService.save(this.department);
		return "list";
	}
	public String update(){
		this.department=(Department) this.baseService.get(Department.class, id);
		this.department.setName(name);
		this.department.setRemarks(remarks);
		Organization organization =(Organization)this.baseService.get(Organization.class, organizationId);
		this.department.setOrganization(organization);
		this.baseService.update(this.department);
		return "list";
	}
	public String byOrigination(){
		this.list=this.baseService.getByHal("from department where organization.id="+id);
		return "departmentList";
	}
	public String introduce(){
		this.department=(Department) this.baseService.get(Department.class, id);
		return "success";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public List<Organization> getOrganizationList() {
		return organizationList;
	}
	public void setOrganizationList(List<Organization> organizationList) {
		this.organizationList = organizationList;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
