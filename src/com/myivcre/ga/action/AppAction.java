package com.myivcre.ga.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.myivcre.ga.model.Department;
import com.myivcre.ga.model.MailItem;
import com.myivcre.ga.model.Organization;
import com.myivcre.ga.model.People;
import com.myivcre.ga.model.PeopleChat;
import com.myivcre.ga.model.Video;

@Component("appAction")
@Scope("prototype")
public class AppAction extends BaseAction {
	private String telphone;
	private String password;
	Video video;
	private String userid;
	private String channelid;
	/**
	 * 获得图片列表
	 * @return
	 */
	public String getPictureNewsList(){
		Logger.getAnonymousLogger().info("pageNum:"+pageNum);
		try {
			this.pageModel=this.baseService.getPageModel("picturenews", pageNum, 6);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String s=JSON.toJSONString(this.pageModel.getObjects(),true);
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
		Logger.getAnonymousLogger().info("getPeopleList");
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
		Logger.getAnonymousLogger().info("id:"+id);
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
		Logger.getAnonymousLogger().info("pageNum:"+pageNum);
		try {
			this.pageModel=this.baseService.getPageModel("video", pageNum, 6);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String json=JSON.toJSONString(this.pageModel.getObjects(),true);
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
		Logger.getAnonymousLogger().info("id:"+id);
		this.video=(Video)this.baseService.get(Video.class, id);
		return "videoContent";
	}
	/**
	 * 用户登录  登陆成功返回id   登陆失败返回0
	 * @return
	 */
	public String login(){
		Logger.getAnonymousLogger().info("telphone "+telphone+" password "+password);
		this.list=this.baseService.getByHal("from people where telphone='"+this.telphone+"' and password='"+this.password+"'");
		PrintWriter out = null;
		try {
			out = ServletActionContext.getResponse().getWriter();
			System.out.println(list.size());
			if(list.size()==0){
				out.print("0");
			}else{
				People p=(People)this.list.get(0);
				out.print(p.getId());
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 更改密码  
	 * 传入id password  
	 * 返回{"state": "success"}
	 * @return
	 */
	public String changePassword(){
		Logger.getAnonymousLogger().info("id "+id+" password "+password);
		People p=(People)this.baseService.get(People.class, id);
		p.setPassword(password);
		this.baseService.update(p);
		PrintWriter out = null;
		try {
			out = ServletActionContext.getResponse().getWriter();
			out.print("1");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 更改两个id
	 * @return
	 */
	public String changeUserid(){
		Logger.getAnonymousLogger().info(userid+"    "+channelid);
		People p=(People)this.baseService.get(People.class, id);
		if(p.getUserid().equals(userid)){
			
		}else{
			if(p.getChannelid().equals(channelid)){
				p.setUserid(userid);
				this.baseService.update(p);
			}else{
				p.setUserid(userid);
				p.setChannelid(channelid);
				this.baseService.update(p);
			}
		}
		PrintWriter out = null;
		try {
			out = ServletActionContext.getResponse().getWriter();
			out.print(userid+" "+channelid);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getUserId(){
		People p=(People)this.baseService.get(People.class, id);
		PrintWriter out = null;
		try {
			out = ServletActionContext.getResponse().getWriter();
			out.print(p.getUserid());
			p.getChannelid();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getPeoples(){
		this.list=this.baseService.getByHal("from people");
		List<PeopleChat> pcList=new ArrayList();
		for(int i=0; i<list.size(); i++){
			PeopleChat pc=new PeopleChat();
			People p=(People)list.get(i);
			pc.setId(p.getId());
			pc.setUserid(p.getUserid());
			pc.setChannelid(p.getChannelid());
			pcList.add(pc);
		}
		String s=JSON.toJSONString(pcList,true);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			response.setCharacterEncoding("GBK");
			response.getWriter().print(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getPeopleById(){
		People p=(People)this.baseService.get(People.class, id);
		PeopleChat pc=new PeopleChat();
		pc.setChannelid(p.getChannelid());
		pc.setId(p.getId());
		pc.setUserid(p.getUserid());
		String s=JSON.toJSONString(pc,true);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			response.setCharacterEncoding("GBK");
			response.getWriter().print(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getChannelid(){
		People p=(People)this.baseService.get(People.class, id);
		PrintWriter out = null;
		try {
			out = ServletActionContext.getResponse().getWriter();
			out.print(p.getChannelid());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}
	
}
