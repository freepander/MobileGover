package com.myivcre.ga.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 市
 * @author freepander
 *
 */
@Entity(name="city")
public class City {
	@Id@GeneratedValue
	private int id;
	private String name;
	@ManyToOne
	private Province provice;
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
	public Province getProvice() {
		return provice;
	}
	public void setProvice(Province provice) {
		this.provice = provice;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	

}
