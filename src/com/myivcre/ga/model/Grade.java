package com.myivcre.ga.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 * 人员分级/列表
 * @author freepander
 *
 */
@Entity(name="grade")
public class Grade {
	@Id@GeneratedValue
	private int id;
	private String name;
	@ManyToOne
	private Grade parent;
	private String remarks;
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
	public Grade getParent() {
		return parent;
	}
	public void setParent(Grade parent) {
		this.parent = parent;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
