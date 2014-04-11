package com.myivcre.ga.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myivcre.ga.model.Province;

@Component("provinceAction")
@Scope("prototype")
public class ProvinceAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String remarks;
	private Province province;
	
	public String list(){
		try {
			this.pageModel=this.baseService.getPageModel("province", pageNum, 20);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.pageModel.setUrl("curl/province_list?pageNum=");
		return "success";
	}
	public String input(){
		this.province=(Province) this.baseService.get(Province.class, id);
		return "success";
	}
	public String delete(){
		this.province=(Province) this.baseService.get(Province.class, id);
		this.baseService.delete(this.province);
		return "list";
	}
	public String add(){
		System.out.println("privinceAction add");
		this.province=new Province();
		this.province.setName(name);
		this.province.setRemarks(remarks);
		this.baseService.save(this.province);
		return "list";
	}
	public String update(){
		this.province=(Province) this.baseService.get(Province.class, id);
		this.province.setName(name);
		this.province.setRemarks(remarks);
		this.baseService.update(this.province);
		return "list";
	}
	public String introduce(){
		this.province=(Province) this.baseService.get(Province.class, id);
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
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	
}
