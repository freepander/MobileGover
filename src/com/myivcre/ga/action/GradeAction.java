package com.myivcre.ga.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myivcre.ga.model.Grade;

@Component("gradeAction")
@Scope("prototype")
public class GradeAction extends BaseAction {
	private String name;
	private int parentId;
	private String remarks;
	private Grade grade;
	public String list(){
		if(parentId==0){
			 this.list=this.baseService.getByHal("from grade where parent=null");
		}else{
			this.list=this.baseService.getByHal("from grade where parent.id="+this.parentId+"");
		}
		return "success";
	}
	public String update(){
		this.grade=(Grade) this.baseService.get(Grade.class, id);
		this.grade.setName(name);
		this.grade.setRemarks(remarks);
		this.baseService.update(this.grade);
		if(this.grade.getParent()!=null){
			this.parentId=this.grade.getParent().getId();
		}
		return "list";
	}
	public String input(){
		this.grade=(Grade) this.baseService.get(Grade.class, id);
		return "success";
	}
	public String add(){
		this.grade=new Grade();
		this.grade.setName(this.name);
		this.grade.setRemarks(remarks);
		Grade parent=(Grade)this.baseService.get(Grade.class, parentId);
		this.grade.setParent(parent);
		this.baseService.save(this.grade);
		return "list";
	}
	public String delete(){
		this.grade=(Grade) this.baseService.get(Grade.class, id);
		this.baseService.delete(this.grade);
		if(this.grade.getParent()!=null){
			this.parentId=this.grade.getParent().getId();
		}
		return "list";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
}
