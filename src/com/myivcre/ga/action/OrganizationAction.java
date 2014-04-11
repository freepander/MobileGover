package com.myivcre.ga.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myivcre.ga.model.City;
import com.myivcre.ga.model.Organization;

@Component("organizationAction")
@Scope("prototype")
public class OrganizationAction extends BaseAction {
	private String name;
	private String remarks;
	private List<City> cityList;
	private Organization organization;
	public String list(){
		try{
			this.pageModel=this.baseService.getPageModel("organization", pageNum, 20);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.pageModel.setUrl("curl/organization_list?pageNum=");
		return "success";
	}
	public String input(){
		this.organization=(Organization) this.baseService.get(Organization.class, id);
		return "success";
	}
	public String delete(){
		this.organization=(Organization) this.baseService.get(Organization.class, id);
		this.baseService.delete(this.organization);
		return "list";
	}
	public String add(){
		this.organization=new Organization();
		this.organization.setName(name);
		this.organization.setRemarks(remarks);
		this.baseService.save(this.organization);
		return "list";
	}
	public String update(){
		this.organization=(Organization) this.baseService.get(Organization.class, id);
		this.organization.setName(name);
		this.organization.setRemarks(remarks);
		this.baseService.update(this.organization);
		return "list";
	}
	public String introduce(){
		this.organization=(Organization) this.baseService.get(Organization.class, id);
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
	public List<City> getCityList() {
		return cityList;
	}
	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
}
