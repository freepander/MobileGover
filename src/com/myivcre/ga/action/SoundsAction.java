package com.myivcre.ga.action;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 声音上传
 * @author freepanders
 *
 */
@Component("appsoundsAction")
@Scope("prototype")
public class SoundsAction extends ActionSupport {
	public String upload(){
		System.out.println("soundsAction upload ----------------");
		ActionContext context=ActionContext.getContext();    
	    Map  parameterMap=context.getParameters();
	    Set set=parameterMap.keySet();
	    Iterator<String> it = set.iterator();  
	    while (it.hasNext()) {
	      String str = it.next();
	      System.out.println(str);
	    }
	    return null;
	}
}