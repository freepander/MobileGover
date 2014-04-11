package com.myivcre.ga.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myivcre.ga.model.NewsCategory;

/**
 * 新闻类别管理
 * @author yangjintong
 *
 */
@Component("newsCategoryAction")
@Scope("prototype")
public class NewsCategoryAction extends BaseAction {
	private String name;
	
	public String input(){
		
		return "success";
	}
	public String list(){
		this.list=this.baseService.getByHal("from newscategory");
		return "success";
	}
	public String add(){
		NewsCategory category=new NewsCategory();
		category.setName(name);
		this.baseService.save(category);
		return "list";
	}
	public String delete(){
		NewsCategory category=(NewsCategory) this.baseService.get(NewsCategory.class, id);
		this.baseService.delete(category);
		return "list";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
