package com.myivcre.ga.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myivcre.ga.model.City;
import com.myivcre.ga.model.Province;

@Component("cityAction")
@Scope("prototype")
public class CityAction extends BaseAction {
	private String name;
	private String remarks;
	private int provinceId;
	private List<Province> provinceList;
	private City city;
	public String list(){
		try{
			this.pageModel=this.baseService.getPageModel("city", pageNum, 20);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.pageModel.setUrl("curl/city_list?pageNum=");
		return "success";
	}
	public String input(){
		this.city=(City) this.baseService.get(City.class, id);
		this.provinceList=this.baseService.getByHal("from province");
		return "success";
	}
	public String delete(){
		this.city=(City) this.baseService.get(City.class, id);
		this.baseService.delete(this.city);
		return "list";
	}
	public String add(){
		this.city=new City();
		this.city.setName(name);
		this.city.setRemarks(remarks);
		Province province=(Province) this.baseService.get(Province.class, this.provinceId);
		this.city.setProvice(province);
		this.baseService.save(this.city);
		return "list";
	}
	public String update(){
		this.city=(City) this.baseService.get(City.class, id);
		this.city.setName(name);
		this.city.setRemarks(remarks);
		Province province=(Province) this.baseService.get(Province.class, this.provinceId);
		this.city.setProvice(province);
		this.baseService.update(this.city);
		return "list";
	}
	public String introduce(){
		this.city=(City) this.baseService.get(City.class, id);
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
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public List<Province> getProvinceList() {
		return provinceList;
	}
	public void setProvinceList(List<Province> provinceList) {
		this.provinceList = provinceList;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	
	
}
