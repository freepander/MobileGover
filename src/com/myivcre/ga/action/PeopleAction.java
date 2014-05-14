package com.myivcre.ga.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myivcre.ga.model.Department;
import com.myivcre.ga.model.People;


@Component("peopleAction")
@Scope("prototype")
public class PeopleAction extends BaseAction {
	private String name;
	private int departmentId;
	private String logo;
	private String remarks;
	private String post;
	private String officeTelphone;
	private String residential;
	private boolean sex;
	private String telphone;
	private String telphone2;
	private String address;
	private People people;
	
	public String list(){
		orderby.add("id desc");
		try {
			this.pageModel=this.baseService.getPageModel("people", pageNum, 40, orderby, q, a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public String delete(){
		this.people=(People)this.baseService.get(People.class, id);
		this.baseService.delete(this.people);
		return "list";
	}
	public String update(){
		this.people=(People)this.baseService.get(People.class, id);
		this.people.setName(name);
		Department d=(Department)this.baseService.get(Department.class, departmentId);
		this.people.setDepartment(d);
		this.people.setLogo(logo);
		this.people.setRemarks(remarks);
		this.people.setPost(post);
		this.people.setOfficeTelphone(officeTelphone);
		this.people.setResidential(residential);
		this.people.setSex(sex);
		this.people.setTelphone(this.telphone);
		this.people.setAddress(address);
		this.people.setTelphone2(telphone2);
		this.baseService.update(this.people);
		return "list";
	}
	public String add(){
		this.people=new People();
		this.people.setName(name);
		Department d=(Department)this.baseService.get(Department.class, departmentId);
		this.people.setDepartment(d);
		this.people.setLogo(logo);
		this.people.setRemarks(remarks);
		this.people.setPost(post);
		this.people.setOfficeTelphone(officeTelphone);
		this.people.setResidential(residential);
		this.people.setSex(sex);
		this.people.setTelphone(this.telphone);
		this.people.setAddress(address);
		this.people.setTelphone2(telphone2);
		this.people.setPassword("111111");
		this.baseService.save(this.people);
		return "list";
	}
	public String input(){
		if(id!=0){
			this.people=(People)this.baseService.get(People.class, id);
		}
		this.list=this.baseService.getByHal("from department");
		return "success";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getOfficeTelphone() {
		return officeTelphone;
	}
	public void setOfficeTelphone(String officeTelphone) {
		this.officeTelphone = officeTelphone;
	}
	public String getResidential() {
		return residential;
	}
	public void setResidential(String residential) {
		this.residential = residential;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelphone2() {
		return telphone2;
	}
	public void setTelphone2(String telphone2) {
		this.telphone2 = telphone2;
	}
	public People getPeople() {
		return people;
	}
	public void setPeople(People people) {
		this.people = people;
	}

}
