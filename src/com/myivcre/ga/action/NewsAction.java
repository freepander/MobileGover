package com.myivcre.ga.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.myivcre.ga.model.News;
import com.myivcre.ga.model.NewsCategory;
import com.opensymphony.xwork2.ActionContext;

@Component("newsAction")
@Scope("prototype")
public class NewsAction extends BaseAction {
	private String title;
	private String description;
	private String img;
	private String content;
	private String date;
	private News news;
	private int categoryId;
	public String list(){
		try {
			orderby.add("id desc");
			this.pageModel=this.baseService.getPageModel("news", 1, 20, orderby, q, a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.pageModel.setUrl("curl/news_list?pageNum=");
		return "success";
	}
	public String add() throws IOException{
		this.news=new News();
		this.news.setTitle(title);
		this.news.setDate(date);
		this.news.setContent(content);
		this.news.setDescription(description);
		this.news.setImg(img);
		NewsCategory category=(NewsCategory) this.baseService.get(NewsCategory.class, categoryId);
		this.news.setCategory(category);
		this.baseService.save(this.news);
		return "list";
	}
	public String input(){
		if(id!=0){
			this.news=(News) this.baseService.get(News.class, id);
		}
		this.list=this.baseService.getByHal("from newscategory");
		return "success";
	}
	public String delete(){
		this.news=(News) this.baseService.get(News.class, id);
		this.baseService.delete(this.news);
		return "list";
	}	
	public String update(){
		this.news=(News) this.baseService.get(News.class, id);
		this.news.setTitle(title);
		this.news.setDate(date);
		this.news.setContent(content);
		this.news.setDescription(description);
		this.news.setImg(img);
		NewsCategory category=(NewsCategory) this.baseService.get(NewsCategory.class, categoryId);
		this.news.setCategory(category);
		this.baseService.update(this.news);
		return "list";
	}
	/**
	 * 将本条新闻设置为本模块头条新闻
	 * @return
	 */
	public String setMain(){
		this.news=(News) this.baseService.get(News.class, id);
		this.list=this.baseService.getByHal("from news where category.id="+this.news.getCategory().getId()+"");
		for(int i=0;i<list.size();i++){
			News s=(News) this.list.get(i);
			s.setMain(false);
			this.baseService.update(s);
		}
		this.news.setMain(true);
		this.baseService.update(this.news);
		return "list";
	}
	
	/**
	 * 新闻详细内容
	 * @return
	 */
	public String content(){
		this.news=(News) this.baseService.get(News.class, id);
		return "newsContent";
	}
	/**
	 * 各个新闻列表
	 * @return
	 */
	public String getNews1(){
		this.list=this.baseService.getByHal("from news where category.name='要闻' and main=false");
		String s=JSON.toJSONString(this.list,false);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			response.setCharacterEncoding("GBK");
			response.getWriter().print(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getNews2(){
		this.list=this.baseService.getByHal("from news where category.name='公开' and main=false");
		String s=JSON.toJSONString(this.list,true);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			response.setCharacterEncoding("GBK");
			response.getWriter().print(s);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getNews3(){
		this.list=this.baseService.getByHal("from news where category.name='学习' and main=false");
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
	public String getNew1(){
		this.news=(News)this.baseService.getByHal("from news where category.name='要闻' and main=true").get(0);
		String s=JSON.toJSONString(this.news,true);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			response.setCharacterEncoding("GBK");
			response.getWriter().print(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getNew2(){
		this.news=(News)this.baseService.getByHal("from news where category.name='公开' and main=true").get(0);
		String s=JSON.toJSONString(this.news,true);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			response.setCharacterEncoding("GBK");
			response.getWriter().print(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getNew3(){
		this.news=(News)this.baseService.getByHal("from news where category.name='学习' and main=true").get(0);
		String s=JSON.toJSONString(this.news,true);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			response.setCharacterEncoding("GBK");
			response.getWriter().print(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String postJson(){
		
		return null;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


}
