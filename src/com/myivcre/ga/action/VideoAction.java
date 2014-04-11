package com.myivcre.ga.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myivcre.ga.model.Video;

/**
 * @author freepander
 *
 */
@Component("videoAction")
@Scope("prototype")
public class VideoAction extends BaseAction {
	private String title;
	private String address;
	private Video video;
	private String img;
	public String input(){
		if(id!=0){
			this.video=(Video)this.baseService.get(Video.class, id);
		}
		return "success";
	}
	public String list(){
		try {
			this.pageModel=this.baseService.getPageModel("video", pageNum, 20);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public String add(){
		this.video=new Video();
		this.video.setImg(img);
		this.video.setTitle(title);
		this.video.setAddress(address);
		this.baseService.save(this.video);
		return "list";
	}
	public String delete(){
		this.video=(Video)this.baseService.get(Video.class, id);
		this.baseService.delete(this.video);
		return "list";
	}
	public String update(){
		this.video=(Video)this.baseService.get(Video.class, id);
		this.video.setImg(img);
		this.video.setTitle(title);
		this.video.setAddress(address);
		this.baseService.update(this.video);
		return "list";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	
}
