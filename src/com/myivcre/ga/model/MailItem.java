package com.myivcre.ga.model;

/**
 * 通讯录的一个item，不需要保存到数据库中
 * 
 * @author freepander
 * 
 */
public class MailItem {
	// 当前元素id	grade类元素为1开始，people类元素为2开始
	private String id;
	// 当前元素级别   从1开始
	private int level;
	// 当前元素名称
	private String title;
	//
	private boolean fold=false;
	// 当前元素是否有子节点
	private boolean hasChild;
	// 是否有父节点
	private boolean hasParent;
	// 父节点id
	private String parentId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isFold() {
		return fold;
	}
	public void setFold(boolean fold) {
		this.fold = fold;
	}
	public boolean isHasChild() {
		return hasChild;
	}
	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}
	public boolean isHasParent() {
		return hasParent;
	}
	public void setHasParent(boolean hasParent) {
		this.hasParent = hasParent;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 机构转换成MailItem
	 * @param o
	 */
	public static MailItem organizationToItem(Organization o){
		MailItem m=new MailItem();
		m.setId(String.valueOf(o.getId()));
		m.setLevel(1);
		m.setTitle(o.getName());
		m.setFold(false);
		m.setHasChild(true);
		m.setHasParent(false);
		m.setParentId(null);
		return m;
	}
	/**
	 * 部门转化成Item
	 */
	public static MailItem departmentToItem(Department d){
		MailItem m=new MailItem();
		m.setId(String.valueOf(d.getId()));
		m.setLevel(2);
		m.setTitle(d.getName());
		m.setFold(false);
		m.setHasChild(true);
		m.setHasParent(true);
		m.setParentId(String.valueOf(d.getOrganization().getId()));
		return m;
	}
	/**
	 * 人员转换成MailItem
	 * @param p
	 * @return
	 */
	public static MailItem peopleToItem(People p){
		MailItem m=new MailItem();
		m.setId(String.valueOf(p.getId()));
		m.setLevel(3);
		m.setTitle(p.getName());
		m.setFold(false);
		m.setHasChild(false);
		m.setHasParent(true);
		m.setParentId(String.valueOf(p.getDepartment().getId()));
		return m;
	}
//	public static MailItem gradeToMailItem(Grade grade, int level,boolean isHasChild) {
//		MailItem item=new MailItem();
//		String s="1"+String.valueOf(grade.getId());
//		item.setS(s);
//		item.setB(String.valueOf(level));
//		item.setM(grade.getName());
//		item.setT(false);
//		item.setZ(isHasChild);
//		if(grade.getParent()!=null){
//			item.setA(true);
//			String n="1"+String.valueOf(grade.getParent().getId());
//			item.setN(n);
//		}else{
//			item.setA(false);
//			item.setN("null");
//		}
//		return item;
//	}
//
//	public static MailItem peopleToMailItem(People people, int level) {
//		MailItem item=new MailItem();
//		String s="2"+String.valueOf(people.getId());
//		item.setS(s);
//		item.setB(String.valueOf(level));
//		item.setM(people.getName());
//		item.setT(false);
//		item.setZ(false);
//		item.setA(true);
////		item.setN("1"+String.valueOf(people.getGrade().getId()));
//		return item;
//	}


}
