package com.myivcre.ga.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myivcre.ga.model.Admin;

/**
 * 后台管理员
 * @author freepander
 *
 */
@Component("adminAction")
@Scope("prototype")
public class AdminAction extends BaseAction {
	private String username;
	private String password;
	private String name;
	
	private Admin admin;
	public String list(){
		return "success";
	}
	public String login(){
		//从数据库中根据用户名密码查找用户
		try {
			q.add("username=?");
			a.add(this.username);
			q.add("password=?");
			a.add(this.password);
			this.pageModel=this.baseService.getPageModel("admin", 1, 1,q,a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("进入了action");
		//判断用户是否存在
		if(pageModel!=null&&pageModel.getObjects().size()>0){
			System.out.println("进入了if循环");
			this.admin=(Admin)this.pageModel.getObjects().get(0);
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			session.setAttribute("admin_username", this.admin.getUsername());
			session.setAttribute("admin_name", this.admin.getName());
			return "index";
		}
		return "login";
		
	}
	
}
