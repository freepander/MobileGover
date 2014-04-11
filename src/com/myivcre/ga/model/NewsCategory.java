package com.myivcre.ga.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 新闻类别
 * @author yangjintong
 *
 */
@Entity(name="newscategory")
public class NewsCategory {
	@Id@GeneratedValue
	private int id;
	private String name;

	
	
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
	

}
