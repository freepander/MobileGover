package com.myivcre.ga.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.myivcre.ga.model.Department;
import com.myivcre.ga.model.MailItem;
import com.myivcre.ga.model.Organization;
import com.myivcre.ga.model.People;
import com.myivcre.ga.model.Video;

@Component("appAction")
@Scope("prototype")
public class AppAction extends BaseAction {
	Video video;
	/**
	 * 获得图片列表
	 * @return
	 */
	public String getPictureNewsList(){
		this.list=this.baseService.getByHal("from picturenews");
		String s=JSON.toJSONString(this.list,true);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			response.setCharacterEncoding("GBK");
			response.getWriter().print(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获得人员列表
	 * @return
	 */
	public String getPeopleList(){
		List<Organization> organizationList=this.baseService.getByHal("from organization");
		List<MailItem> mailList=new ArrayList();
		for(Organization o:organizationList){
			mailList.add(MailItem.organizationToItem(o));
		}
		List<Department> departmentList=this.baseService.getByHal("from department");
		for(Department d:departmentList){
			mailList.add(MailItem.departmentToItem(d));
		}
		List<People> peopleList=this.baseService.getByHal("from people");
		for(People p:peopleList){
			mailList.add(MailItem.peopleToItem(p));
		}
		String json=JSON.toJSONString(mailList);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			response.setCharacterEncoding("GBK");
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获得人员详细信息
	 * @return
	 */
	public String getPeopleMessage(){
		People p=(People)this.baseService.get(People.class, id);
		String json=JSON.toJSONString(p,true);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			response.setCharacterEncoding("GBK");
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取视频列表
	 */
	public String getVideoList(){
		List list=this.baseService.getByHal("from video");
		String json=JSON.toJSONString(list,true);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			response.setCharacterEncoding("GBK");
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 进入视频播放页面
	 */
	public String getVideoContent(){
		this.video=(Video)this.baseService.get(Video.class, id);
		return "videoContent";
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	
}
