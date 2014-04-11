package com.myivcre.ga.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 用户
 * @author freepander
 *
 */
@Entity(name="people")
public class People {
	@Id@GeneratedValue
	private int id;
	//姓名
	private String name;
	//部门
	@ManyToOne
	private Department department;
	//头像
	private String logo;
	//备注
	private String remarks;
	//职务
	private String post;
	//办公室电话
	private String officeTelphone;
	//住宅电话
	private String residential;
	//性别
	private boolean sex;
	//电话
	private String telphone;
	//地址
	private String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
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
	
	
}
